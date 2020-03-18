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
    private float diU;
    private View.OnClickListener drJ;
    private View fGN;
    private TextView fGO;
    private View fGP;
    private TextView fGQ;
    private TextView fGR;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aGD();
                if (NewAnounceLayout.this.fGM != null && NewAnounceLayout.this.fGM.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.fGM.bud())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.fGM.getTid() + "", (String) null, (String) null, true);
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
        this.fGN = findViewById(R.id.announce_content);
        this.fGN.setOnClickListener(this.drJ);
        this.fGO = (TextView) findViewById(R.id.first_line_tv);
        this.fGP = findViewById(R.id.second_content);
        this.fGQ = (TextView) findViewById(R.id.second_line_tv);
        this.fGR = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.fDc == null || this.fGM == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.diU = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.fHb) {
            this.diU = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.fHd) {
            this.diU = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.fHc) {
            this.diU = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.fGN.setPadding(0, 0, 0, 0);
            this.fGO.setPadding(0, 0, 0, 0);
            this.fGQ.setPadding(0, 0, 0, 0);
            this.fGR.setPadding(0, 0, 0, 0);
        }
        zS(this.fGM.bud());
    }

    private void zS(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.fGP.setVisibility(8);
            this.fGO.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.fGP.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.fGO.getPaint(), (int) this.diU, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.fGP.setVisibility(8);
            this.fGO.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.fGQ.getPaint(), (int) this.diU, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.fGR.setVisibility(8);
        } else {
            this.fGR.setVisibility(0);
        }
        this.fGP.setVisibility(0);
        this.fGO.setText(substring);
        this.fGQ.setText(substring2);
    }

    public void pm(int i) {
        if (this.fGM != null) {
            if (this.status != a.fHc) {
                am.setBackgroundColor(this.fGN, R.color.cp_bg_line_e, i);
            } else if (this.fGN != null) {
                this.fGN.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.fGM.bud())) {
                am.setViewTextColor(this.fGO, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.fGO, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.fGQ, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fGR, R.color.cp_link_tip_c, 1, i);
        }
    }
}
