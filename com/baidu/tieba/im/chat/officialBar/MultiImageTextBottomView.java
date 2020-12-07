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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes26.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b kjW;
    private TbImageView klR;
    private int klS;
    private String klT;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kjW = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.kjW != null) {
                    MultiImageTextBottomView.this.kjW.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.klR = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.klR.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0782a c0782a, View view, final int i) {
        if (c0782a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0782a.title)) {
                str = c0782a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0782a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0782a != null && !StringUtils.isNull(c0782a.url)) {
                            bf.bua().b(tbPageContext, new String[]{c0782a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0782a.fid);
                                com.baidu.tieba.im.data.d NW = com.baidu.tieba.im.util.e.NW(MultiImageTextBottomView.this.klT);
                                if (NW != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", NW.kqk, "task_id", NW.taskId, "loc", "" + MultiImageTextBottomView.this.klS);
                                    if ((c0782a.userType == 1 || c0782a.userType == 3) && !"0".equals(NW.taskId)) {
                                        com.baidu.tieba.im.b.a.dab().NQ(NW.taskId);
                                    }
                                }
                                ar arVar = new ar("official_message_open_detail");
                                arVar.w("msg_id", c0782a.kAw / 100);
                                arVar.dY("official_id", c0782a.kAx);
                                arVar.al("official_type", c0782a.kAy);
                                arVar.w("operate_time", System.currentTimeMillis() / 1000);
                                arVar.w("task_id", c0782a.taskId);
                                arVar.dY("obj_params1", c0782a.url);
                                TiebaStatic.log(arVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0782a.src)) {
                this.klR.setTag(c0782a.src);
                this.klR.startLoad(c0782a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.klR.setBackgroundDrawable(null);
        this.klR.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kjW = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.klS = i;
    }

    public void setTaskInfo(String str) {
        this.klT = str;
    }

    public void se(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.klR.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
