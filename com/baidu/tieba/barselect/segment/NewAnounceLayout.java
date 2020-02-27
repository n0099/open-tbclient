package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes8.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float dit;
    private View.OnClickListener drh;
    private View fFQ;
    private TextView fFR;
    private View fFS;
    private TextView fFT;
    private TextView fFU;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drh = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aGx();
                if (NewAnounceLayout.this.fFP != null && NewAnounceLayout.this.fFP.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.fFP.btV())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.fFP.getTid() + "", (String) null, (String) null, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        initUI();
    }

    protected void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setGravity(17);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.new_announce_layout, (ViewGroup) this, true);
        ns();
    }

    private void ns() {
        this.fFQ = findViewById(R.id.announce_content);
        this.fFQ.setOnClickListener(this.drh);
        this.fFR = (TextView) findViewById(R.id.first_line_tv);
        this.fFS = findViewById(R.id.second_content);
        this.fFT = (TextView) findViewById(R.id.second_line_tv);
        this.fFU = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.fCf == null || this.fFP == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.dit = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.fGe) {
            this.dit = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.fGg) {
            this.dit = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.fGf) {
            this.dit = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.fFQ.setPadding(0, 0, 0, 0);
            this.fFR.setPadding(0, 0, 0, 0);
            this.fFT.setPadding(0, 0, 0, 0);
            this.fFU.setPadding(0, 0, 0, 0);
        }
        zQ(this.fFP.btV());
    }

    private void zQ(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.fFS.setVisibility(8);
            this.fFR.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.fFS.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.fFR.getPaint(), (int) this.dit, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.fFS.setVisibility(8);
            this.fFR.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.fFT.getPaint(), (int) this.dit, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.fFU.setVisibility(8);
        } else {
            this.fFU.setVisibility(0);
        }
        this.fFS.setVisibility(0);
        this.fFR.setText(substring);
        this.fFT.setText(substring2);
    }

    public void pk(int i) {
        if (this.fFP != null) {
            if (this.status != a.fGf) {
                am.setBackgroundColor(this.fFQ, R.color.cp_bg_line_e, i);
            } else if (this.fFQ != null) {
                this.fFQ.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.fFP.btV())) {
                am.setViewTextColor(this.fFR, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.fFR, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.fFT, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fFU, R.color.cp_link_tip_c, 1, i);
        }
    }
}
