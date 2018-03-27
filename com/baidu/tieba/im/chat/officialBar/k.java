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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.g;
/* loaded from: classes3.dex */
public class k extends RelativeLayout {
    private TextView cWV;
    private View chO;
    private TbImageView duL;
    private TextView duU;
    private com.baidu.adp.lib.c.b evU;
    private TextView ezd;
    private ImageView mArrow;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evU = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.single_title);
        this.cWV = (TextView) findViewById(d.g.single_abstract);
        this.duL = (TbImageView) findViewById(d.g.single_content_pic);
        this.duL.setAutoChangeStyle(false);
        this.ezd = (TextView) findViewById(d.g.read_all);
        this.mArrow = (ImageView) findViewById(d.g.arrow);
        this.chO = findViewById(d.g.single_divider);
        this.duU = (TextView) findViewById(d.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.k.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (k.this.evU != null) {
                    k.this.evU.b(view, 9, k.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(final TbPageContext<?> tbPageContext, final g.a aVar, View view, final int i) {
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
            this.cWV.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        aw.Du().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(k.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d nT = com.baidu.tieba.im.util.e.nT(aVar.exJ);
                            if (nT != null) {
                                TiebaStatic.eventStat(k.this.mContext, "message_open_detail", "click", 1, "task_type", nT.eBx, "task_id", nT.taskId, "loc", "0");
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
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.duL.setTag(aVar.src);
                this.duL.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.cWV.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.cWV.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.cWV.setText("");
        this.duL.setBackgroundDrawable(null);
        this.duL.setImageDrawable(null);
        this.duU.setText("");
        this.duU.setVisibility(8);
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
        this.duL.setAutoChangeStyle(z);
        aj.b(this.mTitle, d.C0141d.common_color_10039, 1, skinType);
        aj.b(this.cWV, d.C0141d.cp_cont_c, 1, skinType);
        aj.b(this.ezd, d.C0141d.common_color_10039, 1, skinType);
        aj.f(this.mArrow, d.f.icon_ba_top_arrow_big, skinType);
        aj.b(this.duU, d.C0141d.common_color_10067, 1, skinType);
        aj.f(this.chO, d.f.multi_single_divider_selector, skinType);
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
}
