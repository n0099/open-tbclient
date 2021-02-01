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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes8.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float flf;
    private View isT;
    private TextView isU;
    private View isV;
    private TextView isW;
    private TextView isX;
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
                new ar("c13447").bsO();
                if (NewAnounceLayout.this.isS != null && NewAnounceLayout.this.isS.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.isS.crd()) && NewAnounceLayout.this.isS.crf() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.isS.getTid() + "", (String) null, (String) null, true);
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
        tz();
    }

    private void tz() {
        this.isT = findViewById(R.id.announce_content);
        this.isT.setOnClickListener(this.onClickListener);
        this.isU = (TextView) findViewById(R.id.first_line_tv);
        this.isV = findViewById(R.id.second_content);
        this.isW = (TextView) findViewById(R.id.second_line_tv);
        this.isX = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.iph == null || this.isS == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.flf = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.itg) {
            this.flf = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.iti) {
            this.flf = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.ith) {
            this.flf = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.isT.setPadding(0, 0, 0, 0);
            this.isU.setPadding(0, 0, 0, 0);
            this.isW.setPadding(0, 0, 0, 0);
            this.isX.setPadding(0, 0, 0, 0);
        }
        IK(this.isS.crd());
    }

    private void IK(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.isV.setVisibility(8);
            this.isU.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.isV.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.isU.getPaint(), (int) this.flf, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.isV.setVisibility(8);
            this.isU.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.isW.getPaint(), (int) this.flf, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.isX.setVisibility(8);
        } else {
            this.isX.setVisibility(0);
        }
        this.isV.setVisibility(0);
        this.isU.setText(substring);
        this.isW.setText(substring2);
    }

    public void uu(int i) {
        if (this.isS != null) {
            if (this.status != a.ith) {
                ap.setBackgroundColor(this.isT, R.color.CAM_X0205, i);
            } else if (this.isT != null) {
                this.isT.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.isS.crd())) {
                ap.setViewTextColor(this.isU, R.color.CAM_X0109, 1, i);
            } else {
                ap.setViewTextColor(this.isU, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.isW, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.isX, R.color.CAM_X0304, 1, i);
        }
    }
}
