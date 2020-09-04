package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView dzm;
    private TextView izA;
    private ShareFromFrsMsgData izB;
    private EditText izx;
    private HeadImageView izy;
    private TextView izz;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.izx;
    }

    public void aJ(String str, boolean z) {
        if (this.izy != null) {
            this.izy.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initUI(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.izy.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dzm = (TextView) findViewById(R.id.frs_card_name);
        this.izx = (EditText) findViewById(R.id.chat_msg);
        this.izy = (HeadImageView) findViewById(R.id.frs_card_img);
        this.izA = (TextView) findViewById(R.id.frs_card_member_num);
        this.izz = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.dzm, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izx, R.color.cp_cont_b, 2);
        this.izx.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.izx.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cuO();
    }

    public void cuO() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.izx != null) {
            return k.charSequence2String(this.izx.getText(), null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.izB = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dzm.setText(getShortName(this.izB.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.izB.getImageUrl());
        this.izy.startLoad(this.izB.getImageUrl(), 15, false);
        this.izA.setText(at.numFormatOver10000(this.izB.getMemberNum()));
        this.izz.setText(at.numFormatOver10000(this.izB.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
