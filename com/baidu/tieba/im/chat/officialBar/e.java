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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.g;
/* loaded from: classes3.dex */
public class e extends RelativeLayout {
    private TextView duU;
    private com.baidu.adp.lib.c.b evU;
    private TbImageView exH;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evU = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.exH = (TbImageView) findViewById(d.g.top_content_pic);
        this.exH.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.top_title);
        this.duU = (TextView) findViewById(d.g.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.e.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (e.this.evU != null) {
                    e.this.evU.b(view, 9, e.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(final TbPageContext<?> tbPageContext, final g.a aVar, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30));
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            aw.Du().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(e.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d nT = com.baidu.tieba.im.util.e.nT(aVar.exJ);
                                if (nT != null) {
                                    TiebaStatic.eventStat(e.this.mContext, "message_open_detail", "click", 1, "task_type", nT.eBx, "task_id", nT.taskId, "loc", "0");
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(nT.taskId)) {
                                        com.baidu.tieba.im.b.a.aLZ().nN(nT.taskId);
                                    }
                                }
                                ak akVar = new ak("official_message_open_detail");
                                akVar.f("msg_id", aVar.exQ / 100);
                                akVar.ab("official_id", aVar.exR);
                                akVar.s("official_type", aVar.exS);
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
                this.exH.setTag(aVar.src);
                this.exH.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.duU.setVisibility(8);
            this.duU.setText("");
            return;
        }
        this.duU.setVisibility(0);
        this.duU.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.exH.setBackgroundDrawable(null);
        this.exH.setImageDrawable(null);
        this.duU.setVisibility(8);
        this.duU.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evU = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void hl(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.exH.setAutoChangeStyle(z);
        aj.b(this.mTitle, d.C0141d.cp_cont_g, 1, skinType);
        aj.b(this.duU, d.C0141d.common_color_10067, 1, skinType);
    }
}
