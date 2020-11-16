package com.baidu.tieba.frs.examination;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b extends a {
    private static final int eSb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eSc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eSd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eSe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eSf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eSg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int eSh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private RankStarView eRW;
    private TbImageView iVc;
    private TextView iVd;
    private EditText iVe;
    private TextView iVf;
    private Editable iVg;
    private TextView iaF;
    private View mDivider;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.imj).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.iVc = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.iaF = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.iVd = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.eRW = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.iVe = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.iVf = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.iVc.setPlaceHolder(2);
        this.iVc.setConrers(15);
        this.iVc.setRadius(l.getDimens(this.imj, R.dimen.tbds10));
        this.eRW.setStarSpacing(l.getDimens(this.imj, R.dimen.tbds24));
        this.eRW.setClickable(true);
        this.iVe.setLineSpacing(l.getDimens(this.imj, R.dimen.tbds16), 1.0f);
        if (this.iUX != null) {
            setTag(this.iUX.getTags());
            this.iaF.setText(this.iUX.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iVc.getLayoutParams();
            if (this.iUX.getIconSize() == 1.0d) {
                layoutParams.width = eSb;
                layoutParams.height = eSc;
            } else if (this.iUX.getIconSize() == 0.67d) {
                layoutParams.width = eSd;
                layoutParams.height = eSe;
            } else {
                layoutParams.width = eSf;
                layoutParams.height = eSg;
            }
            this.iVc.setLayoutParams(layoutParams);
            this.iVc.startLoad(this.iUX.icon_url, 10, false);
            if (this.iUX.getScore() != null && this.iUX.getScore().isCommented == 1) {
                this.eRW.setStarCount(this.iUX.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.imj, view);
                    return false;
                }
                return false;
            }
        });
        this.iUY.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.imj.HidenSoftKeyPad(inputMethodManager, b.this.iVe);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cBW() {
        this.iKB.setOnClickListener(this);
        this.iUW.setOnClickListener(this);
        this.iVe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.iVg = editable;
                if (b.this.iVg.length() > 500) {
                    b.this.iVf.setText(String.format(b.this.imj.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.iVg.length())));
                    b.this.iVf.setVisibility(0);
                } else {
                    b.this.iVf.setVisibility(8);
                }
                b.this.cCa();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bzS() {
        if (this.iUV != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.eRW.getStarCount());
            writeData.setOtherComment(this.iVe.getText().toString());
            x.c(String.valueOf(this.iUV.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cBY() {
        if (this.iUV != null) {
            x.f(String.valueOf(this.iUV.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.eRW.setStarCount(writeData.getOtherGrade());
                        b.this.iVe.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iKB) {
            cBX();
        } else if (view == this.iUW) {
            if (TextUtils.isEmpty(this.iVg) || this.iVg.length() < 20) {
                l.showToast(this.imj, R.string.other_comment_size_short_tip);
            } else if (this.iVg.length() > 500) {
                l.showToast(this.imj, R.string.other_comment_size_long_tip);
            } else {
                this.iUY.a(this.iVg.toString(), cCb(), this.iUV);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.iVd.setVisibility(8);
            return;
        }
        this.iVd.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eSh), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.iVd.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCa() {
        if (!TextUtils.isEmpty(this.iVg) && this.iVg.length() >= 20 && this.iVg.length() <= 500) {
            this.iUW.setAlpha(1.0f);
        } else {
            this.iUW.setAlpha(0.5f);
        }
    }

    private String cCb() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.eRW.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        ap.setViewTextColor(this.iaF, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVd, R.color.CAM_X0109);
        this.eRW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.iVe, R.color.CAM_X0105);
        this.iVe.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        ap.setViewTextColor(this.iVf, R.color.CAM_X0301);
        if (this.iVc != null) {
            this.iVc.setPlaceHolder(2);
            this.iVc.invalidate();
        }
    }
}
