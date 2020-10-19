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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes21.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float eIZ;
    private View.OnClickListener eTU;
    private View hBJ;
    private TextView hBK;
    private View hBL;
    private TextView hBM;
    private TextView hBN;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new aq("c13447").bmR();
                if (NewAnounceLayout.this.hBI != null && NewAnounceLayout.this.hBI.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.hBI.chs()) && NewAnounceLayout.this.hBI.chu() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.hBI.getTid() + "", (String) null, (String) null, true);
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
        ul();
    }

    private void ul() {
        this.hBJ = findViewById(R.id.announce_content);
        this.hBJ.setOnClickListener(this.eTU);
        this.hBK = (TextView) findViewById(R.id.first_line_tv);
        this.hBL = findViewById(R.id.second_content);
        this.hBM = (TextView) findViewById(R.id.second_line_tv);
        this.hBN = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.hxT == null || this.hBI == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eIZ = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.hBW) {
            this.eIZ = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.hBY) {
            this.eIZ = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.hBX) {
            this.eIZ = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.hBJ.setPadding(0, 0, 0, 0);
            this.hBK.setPadding(0, 0, 0, 0);
            this.hBM.setPadding(0, 0, 0, 0);
            this.hBN.setPadding(0, 0, 0, 0);
        }
        Ih(this.hBI.chs());
    }

    private void Ih(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.hBL.setVisibility(8);
            this.hBK.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.hBL.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.hBK.getPaint(), (int) this.eIZ, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.hBL.setVisibility(8);
            this.hBK.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.hBM.getPaint(), (int) this.eIZ, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.hBN.setVisibility(8);
        } else {
            this.hBN.setVisibility(0);
        }
        this.hBL.setVisibility(0);
        this.hBK.setText(substring);
        this.hBM.setText(substring2);
    }

    public void uc(int i) {
        if (this.hBI != null) {
            if (this.status != a.hBX) {
                ap.setBackgroundColor(this.hBJ, R.color.cp_bg_line_e, i);
            } else if (this.hBJ != null) {
                this.hBJ.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.hBI.chs())) {
                ap.setViewTextColor(this.hBK, R.color.cp_cont_d, 1, i);
            } else {
                ap.setViewTextColor(this.hBK, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.hBM, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hBN, R.color.cp_link_tip_c, 1, i);
        }
    }
}
