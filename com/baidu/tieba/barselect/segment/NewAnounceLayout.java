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
    private float dXg;
    private View.OnClickListener ege;
    private TextView gAA;
    private View gAB;
    private TextView gAC;
    private TextView gAD;
    private View gAz;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aUT();
                if (NewAnounceLayout.this.gAy != null && NewAnounceLayout.this.gAy.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.gAy.bKg())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.gAy.getTid() + "", (String) null, (String) null, true);
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
        rV();
    }

    private void rV() {
        this.gAz = findViewById(R.id.announce_content);
        this.gAz.setOnClickListener(this.ege);
        this.gAA = (TextView) findViewById(R.id.first_line_tv);
        this.gAB = findViewById(R.id.second_content);
        this.gAC = (TextView) findViewById(R.id.second_line_tv);
        this.gAD = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.gwL == null || this.gAy == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.gAN) {
            this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.gAP) {
            this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.gAO) {
            this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.gAz.setPadding(0, 0, 0, 0);
            this.gAA.setPadding(0, 0, 0, 0);
            this.gAC.setPadding(0, 0, 0, 0);
            this.gAD.setPadding(0, 0, 0, 0);
        }
        Dl(this.gAy.bKg());
    }

    private void Dl(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.gAB.setVisibility(8);
            this.gAA.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.gAB.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.gAA.getPaint(), (int) this.dXg, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.gAB.setVisibility(8);
            this.gAA.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.gAC.getPaint(), (int) this.dXg, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.gAD.setVisibility(8);
        } else {
            this.gAD.setVisibility(0);
        }
        this.gAB.setVisibility(0);
        this.gAA.setText(substring);
        this.gAC.setText(substring2);
    }

    public void qk(int i) {
        if (this.gAy != null) {
            if (this.status != a.gAO) {
                am.setBackgroundColor(this.gAz, R.color.cp_bg_line_e, i);
            } else if (this.gAz != null) {
                this.gAz.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.gAy.bKg())) {
                am.setViewTextColor(this.gAA, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.gAA, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.gAC, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.gAD, R.color.cp_link_tip_c, 1, i);
        }
    }
}
