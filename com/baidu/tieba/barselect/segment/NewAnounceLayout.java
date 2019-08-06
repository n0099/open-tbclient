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
    private float ccv;
    private View.OnClickListener cmb;
    private View eyL;
    private TextView eyM;
    private View eyN;
    private TextView eyO;
    private TextView eyP;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmb = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").ajk();
                if (NewAnounceLayout.this.eyK != null && NewAnounceLayout.this.eyK.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.eyK.aYF())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.eyK.getTid() + "", (String) null, (String) null, true);
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
        this.eyL = findViewById(R.id.announce_content);
        this.eyL.setOnClickListener(this.cmb);
        this.eyM = (TextView) findViewById(R.id.first_line_tv);
        this.eyN = findViewById(R.id.second_content);
        this.eyO = (TextView) findViewById(R.id.second_line_tv);
        this.eyP = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.euT == null || this.eyK == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.ccv = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.eyZ) {
            this.ccv = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.ezb) {
            this.ccv = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.eza) {
            this.ccv = l.v((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds86) * 2);
            this.eyL.setPadding(0, 0, 0, 0);
            this.eyM.setPadding(0, 0, 0, 0);
            this.eyO.setPadding(0, 0, 0, 0);
            this.eyP.setPadding(0, 0, 0, 0);
        }
        vv(this.eyK.aYF());
    }

    private void vv(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.eyN.setVisibility(8);
            this.eyM.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.eyN.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.eyM.getPaint(), (int) this.ccv, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.eyN.setVisibility(8);
            this.eyM.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.eyO.getPaint(), (int) this.ccv, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.eyP.setVisibility(8);
        } else {
            this.eyP.setVisibility(0);
        }
        this.eyN.setVisibility(0);
        this.eyM.setText(substring);
        this.eyO.setText(substring2);
    }

    public void nA(int i) {
        if (this.eyK != null) {
            if (this.status != a.eza) {
                am.h(this.eyL, R.color.cp_bg_line_e, i);
            } else if (this.eyL != null) {
                this.eyL.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.eyK.aYF())) {
                am.d(this.eyM, R.color.cp_cont_d, 1, i);
            } else {
                am.d(this.eyM, R.color.cp_cont_b, 1, i);
            }
            am.d(this.eyO, R.color.cp_cont_b, 1, i);
            am.d(this.eyP, R.color.cp_link_tip_c, 1, i);
        }
    }
}
