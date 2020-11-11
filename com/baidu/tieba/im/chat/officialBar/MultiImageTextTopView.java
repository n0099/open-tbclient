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
    private TextView gmt;
    private com.baidu.adp.lib.b.b jVG;
    private TbImageView jXC;
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
        this.jVG = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.jXC = (TbImageView) findViewById(R.id.top_content_pic);
        this.jXC.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.gmt = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.jVG != null) {
                    MultiImageTextTopView.this.jVG.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0764a c0764a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0764a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0764a.title)) {
                str = c0764a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0764a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0764a != null && !StringUtils.isNull(c0764a.url)) {
                            be.brr().b(tbPageContext, new String[]{c0764a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0764a.fid);
                                com.baidu.tieba.im.data.d Nn = com.baidu.tieba.im.util.e.Nn(c0764a.jXE);
                                if (Nn != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Nn.kbW, "task_id", Nn.taskId, "loc", "0");
                                    if ((c0764a.userType == 1 || c0764a.userType == 3) && !"0".equals(Nn.taskId)) {
                                        com.baidu.tieba.im.b.a.cVj().Nh(Nn.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.w("msg_id", c0764a.kmq / 100);
                                aqVar.dR("official_id", c0764a.kmr);
                                aqVar.al("official_type", c0764a.kms);
                                aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.w("task_id", c0764a.taskId);
                                aqVar.dR("obj_params1", c0764a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0764a.src)) {
                this.jXC.setTag(c0764a.src);
                this.jXC.startLoad(c0764a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gmt.setVisibility(8);
            this.gmt.setText("");
            return;
        }
        this.gmt.setVisibility(0);
        this.gmt.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.jXC.setBackgroundDrawable(null);
        this.jXC.setImageDrawable(null);
        this.gmt.setVisibility(8);
        this.gmt.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jVG = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void rz(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jXC.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1, skinType);
        ap.setViewTextColor(this.gmt, R.color.common_color_10067, 1, skinType);
    }
}
