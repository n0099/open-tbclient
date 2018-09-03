package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private View bHR;
    private TextView cYF;
    private TbImageView cYw;
    private TextView cza;
    private com.baidu.adp.lib.c.b ekx;
    private TextView enE;
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
        this.ekx = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(f.h.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(f.g.single_title);
        this.cza = (TextView) findViewById(f.g.single_abstract);
        this.cYw = (TbImageView) findViewById(f.g.single_content_pic);
        this.cYw.setAutoChangeStyle(false);
        this.enE = (TextView) findViewById(f.g.read_all);
        this.mArrow = (ImageView) findViewById(f.g.arrow);
        this.bHR = findViewById(f.g.single_divider);
        this.cYF = (TextView) findViewById(f.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.ekx != null) {
                    SingleImageTextView.this.ekx.b(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(f.e.ds30), 0, 0);
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
            this.cza.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        az.zI().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d oT = com.baidu.tieba.im.util.e.oT(aVar.emm);
                            if (oT != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", oT.eqa, "task_id", oT.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(oT.taskId)) {
                                    com.baidu.tieba.im.b.a.aNv().oN(oT.taskId);
                                }
                            }
                            an anVar = new an("official_message_open_detail");
                            anVar.f("msg_id", aVar.emt / 100);
                            anVar.ae("official_id", aVar.emu);
                            anVar.r("official_type", aVar.emv);
                            anVar.f("operate_time", System.currentTimeMillis() / 1000);
                            anVar.f("task_id", aVar.taskId);
                            anVar.ae("obj_params1", aVar.url);
                            TiebaStatic.log(anVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.cYw.setTag(aVar.src);
                this.cYw.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.cza.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.cza.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.cza.setText("");
        this.cYw.setBackgroundDrawable(null);
        this.cYw.setImageDrawable(null);
        this.cYF.setText("");
        this.cYF.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void hf(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.cYw.setAutoChangeStyle(z);
        am.b(this.mTitle, f.d.common_color_10039, 1, skinType);
        am.b(this.cza, f.d.cp_cont_c, 1, skinType);
        am.b(this.enE, f.d.common_color_10039, 1, skinType);
        am.d(this.mArrow, f.C0146f.icon_ba_top_arrow_big, skinType);
        am.b(this.cYF, f.d.common_color_10067, 1, skinType);
        am.d(this.bHR, f.C0146f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cYF.setVisibility(8);
            this.cYF.setText("");
            return;
        }
        this.cYF.setVisibility(0);
        this.cYF.setText(str);
    }
}
