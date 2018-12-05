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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView cUZ;
    private TbImageView due;
    private TextView dun;
    private com.baidu.adp.lib.c.b eHQ;
    private TextView eKV;
    private ImageView mArrow;
    private Context mContext;
    private View mDivider;
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
        this.eHQ = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(e.h.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(e.g.single_title);
        this.cUZ = (TextView) findViewById(e.g.single_abstract);
        this.due = (TbImageView) findViewById(e.g.single_content_pic);
        this.due.setAutoChangeStyle(false);
        this.eKV = (TextView) findViewById(e.g.read_all);
        this.mArrow = (ImageView) findViewById(e.g.arrow);
        this.mDivider = findViewById(e.g.single_divider);
        this.dun = (TextView) findViewById(e.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.eHQ != null) {
                    SingleImageTextView.this.eHQ.b(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(e.C0210e.ds30), 0, 0);
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
            this.cUZ.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ay.Ef().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", AiAppsUBCStatistic.TYPE_CLICK, 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d qD = com.baidu.tieba.im.util.e.qD(aVar.eJF);
                            if (qD != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qD.eNq, "task_id", qD.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(qD.taskId)) {
                                    com.baidu.tieba.im.b.a.aUn().qx(qD.taskId);
                                }
                            }
                            am amVar = new am("official_message_open_detail");
                            amVar.i("msg_id", aVar.eJM / 100);
                            amVar.aA("official_id", aVar.eJN);
                            amVar.x("official_type", aVar.eJO);
                            amVar.i("operate_time", System.currentTimeMillis() / 1000);
                            amVar.i("task_id", aVar.taskId);
                            amVar.aA("obj_params1", aVar.url);
                            TiebaStatic.log(amVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.due.setTag(aVar.src);
                this.due.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.cUZ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.cUZ.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.cUZ.setText("");
        this.due.setBackgroundDrawable(null);
        this.due.setImageDrawable(null);
        this.dun.setText("");
        this.dun.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eHQ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ih(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.due.setAutoChangeStyle(z);
        al.b(this.mTitle, e.d.common_color_10039, 1, skinType);
        al.b(this.cUZ, e.d.cp_cont_c, 1, skinType);
        al.b(this.eKV, e.d.common_color_10039, 1, skinType);
        al.d(this.mArrow, e.f.icon_ba_top_arrow_big, skinType);
        al.b(this.dun, e.d.common_color_10067, 1, skinType);
        al.d(this.mDivider, e.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dun.setVisibility(8);
            this.dun.setText("");
            return;
        }
        this.dun.setVisibility(0);
        this.dun.setText(str);
    }
}
