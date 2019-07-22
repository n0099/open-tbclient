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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
import java.net.URISyntaxException;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView VW;
    private View aNH;
    private TextView dpV;
    private TbImageView ffP;
    private TextView gBR;
    private com.baidu.adp.lib.c.b gyN;
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
        this.gyN = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.VW = (TextView) findViewById(R.id.single_abstract);
        this.ffP = (TbImageView) findViewById(R.id.single_content_pic);
        this.ffP.setAutoChangeStyle(false);
        this.gBR = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.aNH = findViewById(R.id.single_divider);
        this.dpV = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.gyN != null) {
                    SingleImageTextView.this.gyN.b(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(R.dimen.ds30), 0, 0);
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
            this.VW.setText(str2);
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
                        bb.ajC().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", aVar.fid);
                            com.baidu.tieba.im.data.d zB = com.baidu.tieba.im.util.e.zB(aVar.gAB);
                            if (zB != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", zB.gEl, "task_id", zB.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(zB.taskId)) {
                                    com.baidu.tieba.im.b.a.bGv().zv(zB.taskId);
                                }
                            }
                            an anVar = new an("official_message_open_detail");
                            anVar.l("msg_id", aVar.gAI / 100);
                            anVar.bT("official_id", aVar.gAJ);
                            anVar.P("official_type", aVar.gAK);
                            anVar.l("operate_time", System.currentTimeMillis() / 1000);
                            anVar.l("task_id", aVar.taskId);
                            anVar.bT("obj_params1", aVar.url);
                            TiebaStatic.log(anVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.ffP.setTag(aVar.src);
                this.ffP.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.VW.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.VW.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.VW.setText("");
        this.ffP.setBackgroundDrawable(null);
        this.ffP.setImageDrawable(null);
        this.dpV.setText("");
        this.dpV.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gyN = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void lO(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.ffP.setAutoChangeStyle(z);
        am.d(this.mTitle, R.color.common_color_10039, 1, skinType);
        am.d(this.VW, R.color.cp_cont_c, 1, skinType);
        am.d(this.gBR, R.color.common_color_10039, 1, skinType);
        am.g(this.mArrow, R.drawable.icon_ba_top_arrow_big, skinType);
        am.d(this.dpV, R.color.common_color_10067, 1, skinType);
        am.g(this.aNH, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dpV.setVisibility(8);
            this.dpV.setText("");
            return;
        }
        this.dpV.setVisibility(0);
        this.dpV.setText(str);
    }
}
