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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView cOM;
    private com.baidu.adp.lib.c.b dRE;
    private TbImageView dTq;
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
        this.dRE = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.i.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.dTq = (TbImageView) findViewById(d.g.top_content_pic);
        this.dTq.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.top_title);
        this.cOM = (TextView) findViewById(d.g.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (MultiImageTextTopView.this.dRE != null) {
                    MultiImageTextTopView.this.dRE.b(view2, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view2, final int i) {
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
                    public void onClick(View view3) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            ax.wf().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d oa = com.baidu.tieba.im.util.e.oa(aVar.dTs);
                                if (oa != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", oa.dXf, "task_id", oa.taskId, "loc", "0");
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(oa.taskId)) {
                                        com.baidu.tieba.im.b.a.aGX().nU(oa.taskId);
                                    }
                                }
                                al alVar = new al("official_message_open_detail");
                                alVar.f("msg_id", aVar.dTz / 100);
                                alVar.ac("official_id", aVar.dTA);
                                alVar.r("official_type", aVar.dTB);
                                alVar.f("operate_time", System.currentTimeMillis() / 1000);
                                alVar.f("task_id", aVar.taskId);
                                alVar.ac("obj_params1", aVar.url);
                                TiebaStatic.log(alVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.dTq.setTag(aVar.src);
                this.dTq.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cOM.setVisibility(8);
            this.cOM.setText("");
            return;
        }
        this.cOM.setVisibility(0);
        this.cOM.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.dTq.setBackgroundDrawable(null);
        this.dTq.setImageDrawable(null);
        this.cOM.setVisibility(8);
        this.cOM.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dRE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gM(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.dTq.setAutoChangeStyle(z);
        ak.b(this.mTitle, d.C0126d.cp_cont_g, 1, skinType);
        ak.b(this.cOM, d.C0126d.common_color_10067, 1, skinType);
    }
}
