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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes8.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float fnx;
    private View irW;
    private TextView irX;
    private View irY;
    private TextView irZ;
    private TextView isa;
    private Context mContext;
    private View.OnClickListener onClickListener;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new aq("c13447").bwo();
                if (NewAnounceLayout.this.irV != null && NewAnounceLayout.this.irV.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.irV.ctL()) && NewAnounceLayout.this.irV.ctN() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.irV.getTid() + "", (String) null, (String) null, true);
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
        tN();
    }

    private void tN() {
        this.irW = findViewById(R.id.announce_content);
        this.irW.setOnClickListener(this.onClickListener);
        this.irX = (TextView) findViewById(R.id.first_line_tv);
        this.irY = findViewById(R.id.second_content);
        this.irZ = (TextView) findViewById(R.id.second_line_tv);
        this.isa = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.ioi == null || this.irV == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fnx = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.isj) {
            this.fnx = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.isl) {
            this.fnx = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.isk) {
            this.fnx = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.irW.setPadding(0, 0, 0, 0);
            this.irX.setPadding(0, 0, 0, 0);
            this.irZ.setPadding(0, 0, 0, 0);
            this.isa.setPadding(0, 0, 0, 0);
        }
        Jl(this.irV.ctL());
    }

    private void Jl(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.irY.setVisibility(8);
            this.irX.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.irY.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.irX.getPaint(), (int) this.fnx, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.irY.setVisibility(8);
            this.irX.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.irZ.getPaint(), (int) this.fnx, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.isa.setVisibility(8);
        } else {
            this.isa.setVisibility(0);
        }
        this.irY.setVisibility(0);
        this.irX.setText(substring);
        this.irZ.setText(substring2);
    }

    public void vU(int i) {
        if (this.irV != null) {
            if (this.status != a.isk) {
                ao.setBackgroundColor(this.irW, R.color.CAM_X0205, i);
            } else if (this.irW != null) {
                this.irW.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.irV.ctL())) {
                ao.setViewTextColor(this.irX, R.color.CAM_X0109, 1, i);
            } else {
                ao.setViewTextColor(this.irX, R.color.CAM_X0105, 1, i);
            }
            ao.setViewTextColor(this.irZ, R.color.CAM_X0105, 1, i);
            ao.setViewTextColor(this.isa, R.color.CAM_X0304, 1, i);
        }
    }
}
