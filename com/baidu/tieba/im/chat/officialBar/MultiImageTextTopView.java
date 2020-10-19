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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes26.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView fWB;
    private com.baidu.adp.lib.b.b jDk;
    private TbImageView jFg;
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
        this.jDk = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.jFg = (TbImageView) findViewById(R.id.top_content_pic);
        this.jFg.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.fWB = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.jDk != null) {
                    MultiImageTextTopView.this.jDk.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0734a c0734a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0734a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0734a.title)) {
                str = c0734a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0734a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0734a != null && !StringUtils.isNull(c0734a.url)) {
                            be.bmY().b(tbPageContext, new String[]{c0734a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0734a.fid);
                                com.baidu.tieba.im.data.d My = com.baidu.tieba.im.util.e.My(c0734a.jFi);
                                if (My != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", My.jJA, "task_id", My.taskId, "loc", "0");
                                    if ((c0734a.userType == 1 || c0734a.userType == 3) && !"0".equals(My.taskId)) {
                                        com.baidu.tieba.im.b.a.cPB().Ms(My.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.u("msg_id", c0734a.jTT / 100);
                                aqVar.dK("official_id", c0734a.jTU);
                                aqVar.aj("official_type", c0734a.jTV);
                                aqVar.u("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.u("task_id", c0734a.taskId);
                                aqVar.dK("obj_params1", c0734a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0734a.src)) {
                this.jFg.setTag(c0734a.src);
                this.jFg.startLoad(c0734a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fWB.setVisibility(8);
            this.fWB.setText("");
            return;
        }
        this.fWB.setVisibility(0);
        this.fWB.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.jFg.setBackgroundDrawable(null);
        this.jFg.setImageDrawable(null);
        this.fWB.setVisibility(8);
        this.fWB.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jDk = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void qY(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jFg.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1, skinType);
        ap.setViewTextColor(this.fWB, R.color.common_color_10067, 1, skinType);
    }
}
