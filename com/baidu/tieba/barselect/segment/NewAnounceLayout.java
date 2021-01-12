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
/* loaded from: classes7.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float fiO;
    private View ino;
    private TextView inp;
    private View inq;
    private TextView inr;

    /* renamed from: int  reason: not valid java name */
    private TextView f4int;
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
                new aq("c13447").bsu();
                if (NewAnounceLayout.this.inn != null && NewAnounceLayout.this.inn.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.inn.cpT()) && NewAnounceLayout.this.inn.cpV() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.inn.getTid() + "", (String) null, (String) null, true);
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
        tC();
    }

    private void tC() {
        this.ino = findViewById(R.id.announce_content);
        this.ino.setOnClickListener(this.onClickListener);
        this.inp = (TextView) findViewById(R.id.first_line_tv);
        this.inq = findViewById(R.id.second_content);
        this.inr = (TextView) findViewById(R.id.second_line_tv);
        this.f4int = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.ijz == null || this.inn == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fiO = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.inC) {
            this.fiO = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.inE) {
            this.fiO = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.inD) {
            this.fiO = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.ino.setPadding(0, 0, 0, 0);
            this.inp.setPadding(0, 0, 0, 0);
            this.inr.setPadding(0, 0, 0, 0);
            this.f4int.setPadding(0, 0, 0, 0);
        }
        Ia(this.inn.cpT());
    }

    private void Ia(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.inq.setVisibility(8);
            this.inp.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.inq.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.inp.getPaint(), (int) this.fiO, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.inq.setVisibility(8);
            this.inp.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.inr.getPaint(), (int) this.fiO, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.f4int.setVisibility(8);
        } else {
            this.f4int.setVisibility(0);
        }
        this.inq.setVisibility(0);
        this.inp.setText(substring);
        this.inr.setText(substring2);
    }

    public void uo(int i) {
        if (this.inn != null) {
            if (this.status != a.inD) {
                ao.setBackgroundColor(this.ino, R.color.CAM_X0205, i);
            } else if (this.ino != null) {
                this.ino.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.inn.cpT())) {
                ao.setViewTextColor(this.inp, R.color.CAM_X0109, 1, i);
            } else {
                ao.setViewTextColor(this.inp, R.color.CAM_X0105, 1, i);
            }
            ao.setViewTextColor(this.inr, R.color.CAM_X0105, 1, i);
            ao.setViewTextColor(this.f4int, R.color.CAM_X0304, 1, i);
        }
    }
}
