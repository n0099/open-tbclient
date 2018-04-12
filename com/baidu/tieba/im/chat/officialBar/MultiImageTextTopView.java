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
    private TextView cNI;
    private com.baidu.adp.lib.c.b dQA;
    private TbImageView dSm;
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
        this.dQA = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.i.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.dSm = (TbImageView) findViewById(d.g.top_content_pic);
        this.dSm.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.top_title);
        this.cNI = (TextView) findViewById(d.g.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (MultiImageTextTopView.this.dQA != null) {
                    MultiImageTextTopView.this.dQA.b(view2, 9, MultiImageTextTopView.this.mPosition, 0L);
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
                            ax.wg().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d nX = com.baidu.tieba.im.util.e.nX(aVar.dSo);
                                if (nX != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", nX.dWb, "task_id", nX.taskId, "loc", "0");
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(nX.taskId)) {
                                        com.baidu.tieba.im.b.a.aGZ().nR(nX.taskId);
                                    }
                                }
                                al alVar = new al("official_message_open_detail");
                                alVar.f("msg_id", aVar.dSv / 100);
                                alVar.ac("official_id", aVar.dSw);
                                alVar.r("official_type", aVar.dSx);
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
                this.dSm.setTag(aVar.src);
                this.dSm.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cNI.setVisibility(8);
            this.cNI.setText("");
            return;
        }
        this.cNI.setVisibility(0);
        this.cNI.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.dSm.setBackgroundDrawable(null);
        this.dSm.setImageDrawable(null);
        this.cNI.setVisibility(8);
        this.cNI.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dQA = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gL(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.dSm.setAutoChangeStyle(z);
        ak.b(this.mTitle, d.C0126d.cp_cont_g, 1, skinType);
        ak.b(this.cNI, d.C0126d.common_color_10067, 1, skinType);
    }
}
