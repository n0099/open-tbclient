package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes15.dex */
public class VotedAreaLayout extends CardBasicLayout {
    private TextView ewf;
    private Context mContext;

    public VotedAreaLayout(Context context) {
        this(context, null);
    }

    public VotedAreaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    protected void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.bar_select_bg_voted_area_layout);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds62));
        setMinimumWidth(l.getDimens(getContext(), R.dimen.tbds172));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.voted_area_layout, (ViewGroup) this, true);
        uf();
    }

    private void uf() {
        this.ewf = (TextView) findViewById(R.id.vote_num);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.hbV == null || this.hfJ == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.ewf.setText(at.numFormatOverWan(this.hfJ.caH()) + "票");
        tl(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setMyRecordData(d dVar) {
        if (dVar != null) {
            this.hfJ = dVar;
            this.ewf.setText(at.numFormatOverWan(this.hfJ.caH()) + "票");
        }
    }

    public void tl(int i) {
        ap.setViewTextColor(this.ewf, R.color.cp_cont_b, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_voted_area_layout, i);
    }
}
