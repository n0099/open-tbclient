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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes8.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float eeC;
    private View.OnClickListener eoP;
    private View gNl;
    private TextView gNm;
    private View gNn;
    private TextView gNo;
    private TextView gNp;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new ao("c13447").aWN();
                if (NewAnounceLayout.this.gNk != null && NewAnounceLayout.this.gNk.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.gNk.bNl())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.gNk.getTid() + "", (String) null, (String) null, true);
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
        sq();
    }

    private void sq() {
        this.gNl = findViewById(R.id.announce_content);
        this.gNl.setOnClickListener(this.eoP);
        this.gNm = (TextView) findViewById(R.id.first_line_tv);
        this.gNn = findViewById(R.id.second_content);
        this.gNo = (TextView) findViewById(R.id.second_line_tv);
        this.gNp = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.gJz == null || this.gNk == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eeC = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.gNy) {
            this.eeC = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.gNA) {
            this.eeC = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.gNz) {
            this.eeC = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.gNl.setPadding(0, 0, 0, 0);
            this.gNm.setPadding(0, 0, 0, 0);
            this.gNo.setPadding(0, 0, 0, 0);
            this.gNp.setPadding(0, 0, 0, 0);
        }
        DM(this.gNk.bNl());
    }

    private void DM(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.gNn.setVisibility(8);
            this.gNm.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.gNn.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.gNm.getPaint(), (int) this.eeC, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.gNn.setVisibility(8);
            this.gNm.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.gNo.getPaint(), (int) this.eeC, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.gNp.setVisibility(8);
        } else {
            this.gNp.setVisibility(0);
        }
        this.gNn.setVisibility(0);
        this.gNm.setText(substring);
        this.gNo.setText(substring2);
    }

    public void qJ(int i) {
        if (this.gNk != null) {
            if (this.status != a.gNz) {
                an.setBackgroundColor(this.gNl, R.color.cp_bg_line_e, i);
            } else if (this.gNl != null) {
                this.gNl.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.gNk.bNl())) {
                an.setViewTextColor(this.gNm, R.color.cp_cont_d, 1, i);
            } else {
                an.setViewTextColor(this.gNm, R.color.cp_cont_b, 1, i);
            }
            an.setViewTextColor(this.gNo, R.color.cp_cont_b, 1, i);
            an.setViewTextColor(this.gNp, R.color.cp_link_tip_c, 1, i);
        }
    }
}
