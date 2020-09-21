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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes20.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private View.OnClickListener eHN;
    private float ewP;
    private View hmP;
    private TextView hmQ;
    private View hmR;
    private TextView hmS;
    private TextView hmT;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHN = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new aq("c13447").bki();
                if (NewAnounceLayout.this.hmO != null && NewAnounceLayout.this.hmO.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.hmO.cdW()) && NewAnounceLayout.this.hmO.cdY() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.hmO.getTid() + "", (String) null, (String) null, true);
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
        ul();
    }

    private void ul() {
        this.hmP = findViewById(R.id.announce_content);
        this.hmP.setOnClickListener(this.eHN);
        this.hmQ = (TextView) findViewById(R.id.first_line_tv);
        this.hmR = findViewById(R.id.second_content);
        this.hmS = (TextView) findViewById(R.id.second_line_tv);
        this.hmT = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.hiY == null || this.hmO == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.ewP = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.hnc) {
            this.ewP = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.hne) {
            this.ewP = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.hnd) {
            this.ewP = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.hmP.setPadding(0, 0, 0, 0);
            this.hmQ.setPadding(0, 0, 0, 0);
            this.hmS.setPadding(0, 0, 0, 0);
            this.hmT.setPadding(0, 0, 0, 0);
        }
        Hu(this.hmO.cdW());
    }

    private void Hu(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.hmR.setVisibility(8);
            this.hmQ.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.hmR.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.hmQ.getPaint(), (int) this.ewP, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.hmR.setVisibility(8);
            this.hmQ.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.hmS.getPaint(), (int) this.ewP, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.hmT.setVisibility(8);
        } else {
            this.hmT.setVisibility(0);
        }
        this.hmR.setVisibility(0);
        this.hmQ.setText(substring);
        this.hmS.setText(substring2);
    }

    public void tE(int i) {
        if (this.hmO != null) {
            if (this.status != a.hnd) {
                ap.setBackgroundColor(this.hmP, R.color.cp_bg_line_e, i);
            } else if (this.hmP != null) {
                this.hmP.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.hmO.cdW())) {
                ap.setViewTextColor(this.hmQ, R.color.cp_cont_d, 1, i);
            } else {
                ap.setViewTextColor(this.hmQ, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.hmS, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hmT, R.color.cp_link_tip_c, 1, i);
        }
    }
}
