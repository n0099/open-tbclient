package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes3.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView eKN;
    private com.baidu.adp.lib.c.b gbj;
    private TbImageView gcW;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbj = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.gcW = (TbImageView) findViewById(d.g.top_content_pic);
        this.gcW.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.top_title);
        this.eKN = (TextView) findViewById(d.g.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.gbj != null) {
                    MultiImageTextTopView.this.gbj.b(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30));
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            ba.adA().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d xz = com.baidu.tieba.im.util.e.xz(aVar.gcY);
                                if (xz != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", xz.ggL, "task_id", xz.taskId, "loc", "0");
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
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.gcW.setTag(aVar.src);
                this.gcW.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eKN.setVisibility(8);
            this.eKN.setText("");
            return;
        }
        this.eKN.setVisibility(0);
        this.eKN.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.gcW.setBackgroundDrawable(null);
        this.gcW.setImageDrawable(null);
        this.eKN.setVisibility(8);
        this.eKN.setText("");
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
        this.gcW.setAutoChangeStyle(z);
        al.c(this.mTitle, d.C0277d.cp_cont_g, 1, skinType);
        al.c(this.eKN, d.C0277d.common_color_10067, 1, skinType);
    }
}
