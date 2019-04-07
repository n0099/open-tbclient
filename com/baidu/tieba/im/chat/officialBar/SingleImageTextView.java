package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
import java.net.URISyntaxException;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView XK;
    private View aLe;
    private TbImageView eKD;
    private TextView eKM;
    private com.baidu.adp.lib.c.b gbj;
    private TextView ger;
    private ImageView mArrow;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public SingleImageTextView(Context context) {
        this(context, null);
    }

    public SingleImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbj = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.single_title);
        this.XK = (TextView) findViewById(d.g.single_abstract);
        this.eKD = (TbImageView) findViewById(d.g.single_content_pic);
        this.eKD.setAutoChangeStyle(false);
        this.ger = (TextView) findViewById(d.g.read_all);
        this.mArrow = (ImageView) findViewById(d.g.arrow);
        this.aLe = findViewById(d.g.single_divider);
        this.eKM = (TextView) findViewById(d.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.gbj != null) {
                    SingleImageTextView.this.gbj.b(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(d.e.ds30), 0, 0);
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(aVar.text)) {
                str2 = aVar.text;
            }
            this.XK.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && aVar.url != null && aVar.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(aVar.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        ba.adA().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d xz = com.baidu.tieba.im.util.e.xz(aVar.gcY);
                            if (xz != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", xz.ggL, "task_id", xz.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(xz.taskId)) {
                                    com.baidu.tieba.im.b.a.bwc().xt(xz.taskId);
                                }
                            }
                            am amVar = new am("official_message_open_detail");
                            amVar.k("msg_id", aVar.gdf / 100);
                            amVar.bJ("official_id", aVar.gdg);
                            amVar.T("official_type", aVar.gdh);
                            amVar.k("operate_time", System.currentTimeMillis() / 1000);
                            amVar.k("task_id", aVar.taskId);
                            amVar.bJ("obj_params1", aVar.url);
                            TiebaStatic.log(amVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.eKD.setTag(aVar.src);
                this.eKD.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.XK.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.XK.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.XK.setText("");
        this.eKD.setBackgroundDrawable(null);
        this.eKD.setImageDrawable(null);
        this.eKM.setText("");
        this.eKM.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gbj = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void kK(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.eKD.setAutoChangeStyle(z);
        al.c(this.mTitle, d.C0277d.common_color_10039, 1, skinType);
        al.c(this.XK, d.C0277d.cp_cont_c, 1, skinType);
        al.c(this.ger, d.C0277d.common_color_10039, 1, skinType);
        al.e(this.mArrow, d.f.icon_ba_top_arrow_big, skinType);
        al.c(this.eKM, d.C0277d.common_color_10067, 1, skinType);
        al.e(this.aLe, d.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eKM.setVisibility(8);
            this.eKM.setText("");
            return;
        }
        this.eKM.setVisibility(0);
        this.eKM.setText(str);
    }
}
