package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.c.b dQx;
    private TbImageView dSj;
    private int dSk;
    private String dSl;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dQx = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (MultiImageTextBottomView.this.dQx != null) {
                    MultiImageTextBottomView.this.dQx.b(view2, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(d.i.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.dSj = (TbImageView) findViewById(d.g.bottom_content_pic);
        this.dSj.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view2, final int i) {
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            ax.wg().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d nX = com.baidu.tieba.im.util.e.nX(MultiImageTextBottomView.this.dSl);
                                if (nX != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", nX.dVY, "task_id", nX.taskId, "loc", "" + MultiImageTextBottomView.this.dSk);
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(nX.taskId)) {
                                        com.baidu.tieba.im.b.a.aGZ().nR(nX.taskId);
                                    }
                                }
                                al alVar = new al("official_message_open_detail");
                                alVar.f("msg_id", aVar.dSs / 100);
                                alVar.ac("official_id", aVar.dSt);
                                alVar.r("official_type", aVar.dSu);
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
                this.dSj.setTag(aVar.src);
                this.dSj.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.dSj.setBackgroundDrawable(null);
        this.dSj.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dQx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.dSk = i;
    }

    public void setTaskInfo(String str) {
        this.dSl = str;
    }

    public void gL(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.dSj.setAutoChangeStyle(z);
        ak.b(this.mTitle, d.C0126d.common_color_10039, 1, skinType);
    }
}
