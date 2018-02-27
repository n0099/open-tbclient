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
    private TextView cWS;
    private View chL;
    private TbImageView duI;
    private TextView duR;
    private com.baidu.adp.lib.c.b evE;
    private TextView eyN;
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
        this.evE = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.single_title);
        this.cWS = (TextView) findViewById(d.g.single_abstract);
        this.duI = (TbImageView) findViewById(d.g.single_content_pic);
        this.duI.setAutoChangeStyle(false);
        this.eyN = (TextView) findViewById(d.g.read_all);
        this.mArrow = (ImageView) findViewById(d.g.arrow);
        this.chL = findViewById(d.g.single_divider);
        this.duR = (TextView) findViewById(d.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.k.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (k.this.evE != null) {
                    k.this.evE.b(view, 9, k.this.mPosition, 0L);
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
            this.cWS.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        aw.Dt().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(k.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d nT = com.baidu.tieba.im.util.e.nT(aVar.exs);
                            if (nT != null) {
                                TiebaStatic.eventStat(k.this.mContext, "message_open_detail", "click", 1, "task_type", nT.eBh, "task_id", nT.taskId, "loc", "0");
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
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.duI.setTag(aVar.src);
                this.duI.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.cWS.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.cWS.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.cWS.setText("");
        this.duI.setBackgroundDrawable(null);
        this.duI.setImageDrawable(null);
        this.duR.setText("");
        this.duR.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void hg(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.duI.setAutoChangeStyle(z);
        aj.b(this.mTitle, d.C0141d.common_color_10039, 1, skinType);
        aj.b(this.cWS, d.C0141d.cp_cont_c, 1, skinType);
        aj.b(this.eyN, d.C0141d.common_color_10039, 1, skinType);
        aj.f(this.mArrow, d.f.icon_ba_top_arrow_big, skinType);
        aj.b(this.duR, d.C0141d.common_color_10067, 1, skinType);
        aj.f(this.chL, d.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.duR.setVisibility(8);
            this.duR.setText("");
            return;
        }
        this.duR.setVisibility(0);
        this.duR.setText(str);
    }
}
