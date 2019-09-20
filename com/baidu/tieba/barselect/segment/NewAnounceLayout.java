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
    private float cdo;
    private View.OnClickListener cmX;
    private View eAu;
    private TextView eAv;
    private View eAw;
    private TextView eAx;
    private TextView eAy;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmX = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").ajq();
                if (NewAnounceLayout.this.eAt != null && NewAnounceLayout.this.eAt.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.eAt.aZj())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.eAt.getTid() + "", (String) null, (String) null, true);
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
        qY();
    }

    private void qY() {
        this.eAu = findViewById(R.id.announce_content);
        this.eAu.setOnClickListener(this.cmX);
        this.eAv = (TextView) findViewById(R.id.first_line_tv);
        this.eAw = findViewById(R.id.second_content);
        this.eAx = (TextView) findViewById(R.id.second_line_tv);
        this.eAy = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.ewD == null || this.eAt == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.cdo = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.eAI) {
            this.cdo = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.eAK) {
            this.cdo = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.eAJ) {
            this.cdo = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds86) * 2);
            this.eAu.setPadding(0, 0, 0, 0);
            this.eAv.setPadding(0, 0, 0, 0);
            this.eAx.setPadding(0, 0, 0, 0);
            this.eAy.setPadding(0, 0, 0, 0);
        }
        vU(this.eAt.aZj());
    }

    private void vU(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.eAw.setVisibility(8);
            this.eAv.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.eAw.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.eAv.getPaint(), (int) this.cdo, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.eAw.setVisibility(8);
            this.eAv.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.eAx.getPaint(), (int) this.cdo, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.eAy.setVisibility(8);
        } else {
            this.eAy.setVisibility(0);
        }
        this.eAw.setVisibility(0);
        this.eAv.setText(substring);
        this.eAx.setText(substring2);
    }

    public void nE(int i) {
        if (this.eAt != null) {
            if (this.status != a.eAJ) {
                am.h(this.eAu, R.color.cp_bg_line_e, i);
            } else if (this.eAu != null) {
                this.eAu.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.eAt.aZj())) {
                am.d(this.eAv, R.color.cp_cont_d, 1, i);
            } else {
                am.d(this.eAv, R.color.cp_cont_b, 1, i);
            }
            am.d(this.eAx, R.color.cp_cont_b, 1, i);
            am.d(this.eAy, R.color.cp_link_tip_c, 1, i);
        }
    }
}
