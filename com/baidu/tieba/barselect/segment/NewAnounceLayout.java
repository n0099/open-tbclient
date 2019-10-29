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
/* loaded from: classes3.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float crC;
    private View.OnClickListener czV;
    private View eJc;
    private TextView eJd;
    private View eJe;
    private TextView eJf;
    private TextView eJg;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czV = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").amK();
                if (NewAnounceLayout.this.eJb != null && NewAnounceLayout.this.eJb.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.eJb.aZn())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.eJb.getTid() + "", (String) null, (String) null, true);
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
        md();
    }

    private void md() {
        this.eJc = findViewById(R.id.announce_content);
        this.eJc.setOnClickListener(this.czV);
        this.eJd = (TextView) findViewById(R.id.first_line_tv);
        this.eJe = findViewById(R.id.second_content);
        this.eJf = (TextView) findViewById(R.id.second_line_tv);
        this.eJg = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.eFp == null || this.eJb == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.crC = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.eJq) {
            this.crC = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.eJs) {
            this.crC = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.eJr) {
            this.crC = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.eJc.setPadding(0, 0, 0, 0);
            this.eJd.setPadding(0, 0, 0, 0);
            this.eJf.setPadding(0, 0, 0, 0);
            this.eJg.setPadding(0, 0, 0, 0);
        }
        ux(this.eJb.aZn());
    }

    private void ux(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.eJe.setVisibility(8);
            this.eJd.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.eJe.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.eJd.getPaint(), (int) this.crC, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.eJe.setVisibility(8);
            this.eJd.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.eJf.getPaint(), (int) this.crC, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.eJg.setVisibility(8);
        } else {
            this.eJg.setVisibility(0);
        }
        this.eJe.setVisibility(0);
        this.eJd.setText(substring);
        this.eJf.setText(substring2);
    }

    public void mE(int i) {
        if (this.eJb != null) {
            if (this.status != a.eJr) {
                am.setBackgroundColor(this.eJc, R.color.cp_bg_line_e, i);
            } else if (this.eJc != null) {
                this.eJc.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.eJb.aZn())) {
                am.setViewTextColor(this.eJd, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.eJd, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.eJf, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.eJg, R.color.cp_link_tip_c, 1, i);
        }
    }
}
