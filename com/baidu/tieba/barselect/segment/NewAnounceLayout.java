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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes3.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float cbk;
    private View.OnClickListener ckH;
    private View etE;
    private TextView etF;
    private View etG;
    private TextView etH;
    private TextView etI;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new am("c13447").aif();
                if (NewAnounceLayout.this.etD != null && NewAnounceLayout.this.etD.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.etD.aWE())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.etD.getTid() + "", (String) null, (String) null, true);
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
        qA();
    }

    private void qA() {
        this.etE = findViewById(R.id.announce_content);
        this.etE.setOnClickListener(this.ckH);
        this.etF = (TextView) findViewById(R.id.first_line_tv);
        this.etG = findViewById(R.id.second_content);
        this.etH = (TextView) findViewById(R.id.second_line_tv);
        this.etI = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.epN == null || this.etD == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.cbk = l.s((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.etS) {
            this.cbk = l.s((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.etU) {
            this.cbk = l.s((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.etT) {
            this.cbk = l.s((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds86) * 2);
            this.etE.setPadding(0, 0, 0, 0);
            this.etF.setPadding(0, 0, 0, 0);
            this.etH.setPadding(0, 0, 0, 0);
            this.etI.setPadding(0, 0, 0, 0);
        }
        uQ(this.etD.aWE());
    }

    private void uQ(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.etG.setVisibility(8);
            this.etF.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.etG.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.etF.getPaint(), (int) this.cbk, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.etG.setVisibility(8);
            this.etF.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.etH.getPaint(), (int) this.cbk, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.etI.setVisibility(8);
        } else {
            this.etI.setVisibility(0);
        }
        this.etG.setVisibility(0);
        this.etF.setText(substring);
        this.etH.setText(substring2);
    }

    public void nq(int i) {
        if (this.etD != null) {
            if (this.status != a.etT) {
                al.h(this.etE, R.color.cp_bg_line_e, i);
            } else if (this.etE != null) {
                this.etE.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.etD.aWE())) {
                al.c(this.etF, R.color.cp_cont_d, 1, i);
            } else {
                al.c(this.etF, R.color.cp_cont_b, 1, i);
            }
            al.c(this.etH, R.color.cp_cont_b, 1, i);
            al.c(this.etI, R.color.cp_link_tip_c, 1, i);
        }
    }
}
