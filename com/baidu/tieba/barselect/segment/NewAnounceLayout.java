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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes3.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float ccn;
    private View.OnClickListener clU;
    private View eyE;
    private TextView eyF;
    private View eyG;
    private TextView eyH;
    private TextView eyI;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aji();
                if (NewAnounceLayout.this.eyD != null && NewAnounceLayout.this.eyD.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.eyD.aYD())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.eyD.getTid() + "", (String) null, (String) null, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
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
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.new_announce_layout, (ViewGroup) this, true);
        qX();
    }

    private void qX() {
        this.eyE = findViewById(R.id.announce_content);
        this.eyE.setOnClickListener(this.clU);
        this.eyF = (TextView) findViewById(R.id.first_line_tv);
        this.eyG = findViewById(R.id.second_content);
        this.eyH = (TextView) findViewById(R.id.second_line_tv);
        this.eyI = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.euM == null || this.eyD == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.ccn = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.eyS) {
            this.ccn = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.eyU) {
            this.ccn = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.eyT) {
            this.ccn = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds86) * 2);
            this.eyE.setPadding(0, 0, 0, 0);
            this.eyF.setPadding(0, 0, 0, 0);
            this.eyH.setPadding(0, 0, 0, 0);
            this.eyI.setPadding(0, 0, 0, 0);
        }
        vu(this.eyD.aYD());
    }

    private void vu(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.eyG.setVisibility(8);
            this.eyF.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.eyG.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.eyF.getPaint(), (int) this.ccn, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.eyG.setVisibility(8);
            this.eyF.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.eyH.getPaint(), (int) this.ccn, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.eyI.setVisibility(8);
        } else {
            this.eyI.setVisibility(0);
        }
        this.eyG.setVisibility(0);
        this.eyF.setText(substring);
        this.eyH.setText(substring2);
    }

    public void nz(int i) {
        if (this.eyD != null) {
            if (this.status != a.eyT) {
                am.h(this.eyE, R.color.cp_bg_line_e, i);
            } else if (this.eyE != null) {
                this.eyE.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.eyD.aYD())) {
                am.d(this.eyF, R.color.cp_cont_d, 1, i);
            } else {
                am.d(this.eyF, R.color.cp_cont_b, 1, i);
            }
            am.d(this.eyH, R.color.cp_cont_b, 1, i);
            am.d(this.eyI, R.color.cp_link_tip_c, 1, i);
        }
    }
}
