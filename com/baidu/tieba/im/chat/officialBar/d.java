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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.g;
/* loaded from: classes3.dex */
public class d extends LinearLayout {
    private com.baidu.adp.lib.c.b evE;
    private TbImageView exq;
    private int exr;
    private String exs;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evE = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.d.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (d.this.evE != null) {
                    d.this.evE.b(view, 9, d.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(d.h.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.exq = (TbImageView) findViewById(d.g.bottom_content_pic);
        this.exq.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.bottom_title);
    }

    public void a(final TbPageContext<?> tbPageContext, final g.a aVar, View view, final int i) {
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            aw.Dt().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(d.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d nT = com.baidu.tieba.im.util.e.nT(d.this.exs);
                                if (nT != null) {
                                    TiebaStatic.eventStat(d.this.mContext, "message_open_detail", "click", 1, "task_type", nT.eBh, "task_id", nT.taskId, "loc", "" + d.this.exr);
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(nT.taskId)) {
                                        com.baidu.tieba.im.b.a.aLY().nN(nT.taskId);
                                    }
                                }
                                ak akVar = new ak("official_message_open_detail");
                                akVar.f("msg_id", aVar.exA / 100);
                                akVar.ab("official_id", aVar.exB);
                                akVar.s("official_type", aVar.exC);
                                akVar.f("operate_time", System.currentTimeMillis() / 1000);
                                akVar.f("task_id", aVar.taskId);
                                akVar.ab("obj_params1", aVar.url);
                                TiebaStatic.log(akVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.exq.setTag(aVar.src);
                this.exq.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.exq.setBackgroundDrawable(null);
        this.exq.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.exr = i;
    }

    public void setTaskInfo(String str) {
        this.exs = str;
    }

    public void hg(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.exq.setAutoChangeStyle(z);
        aj.b(this.mTitle, d.C0141d.common_color_10039, 1, skinType);
    }
}
