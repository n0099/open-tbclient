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
/* loaded from: classes22.dex */
public class b extends a {
    private static final int eEO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eEP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eEQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eER = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eES = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eET = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int eEU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private RankStarView eEJ;
    private TextView hHK;
    private TbImageView iBX;
    private TextView iBY;
    private EditText iBZ;
    private TextView iCa;
    private Editable iCb;
    private View mDivider;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hSW).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.iBX = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.hHK = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.iBY = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.eEJ = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.iBZ = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.iCa = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.iBX.setPlaceHolder(2);
        this.iBX.setConrers(15);
        this.iBX.setRadius(l.getDimens(this.hSW, R.dimen.tbds10));
        this.eEJ.setStarSpacing(l.getDimens(this.hSW, R.dimen.tbds24));
        this.eEJ.setClickable(true);
        this.iBZ.setLineSpacing(l.getDimens(this.hSW, R.dimen.tbds16), 1.0f);
        if (this.iBS != null) {
            setTag(this.iBS.getTags());
            this.hHK.setText(this.iBS.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iBX.getLayoutParams();
            if (this.iBS.getIconSize() == 1.0d) {
                layoutParams.width = eEO;
                layoutParams.height = eEP;
            } else if (this.iBS.getIconSize() == 0.67d) {
                layoutParams.width = eEQ;
                layoutParams.height = eER;
            } else {
                layoutParams.width = eES;
                layoutParams.height = eET;
            }
            this.iBX.setLayoutParams(layoutParams);
            this.iBX.startLoad(this.iBS.icon_url, 10, false);
            if (this.iBS.getScore() != null && this.iBS.getScore().isCommented == 1) {
                this.eEJ.setStarCount(this.iBS.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.hSW, view);
                    return false;
                }
                return false;
            }
        });
        this.iBT.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.hSW.HidenSoftKeyPad(inputMethodManager, b.this.iBZ);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cwK() {
        this.irv.setOnClickListener(this);
        this.iBR.setOnClickListener(this);
        this.iBZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.iCb = editable;
                if (b.this.iCb.length() > 500) {
                    b.this.iCa.setText(String.format(b.this.hSW.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.iCb.length())));
                    b.this.iCa.setVisibility(0);
                } else {
                    b.this.iCa.setVisibility(8);
                }
                b.this.cwO();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bwk() {
        if (this.iBQ != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.eEJ.getStarCount());
            writeData.setOtherComment(this.iBZ.getText().toString());
            x.c(String.valueOf(this.iBQ.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cwM() {
        if (this.iBQ != null) {
            x.f(String.valueOf(this.iBQ.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.eEJ.setStarCount(writeData.getOtherGrade());
                        b.this.iBZ.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.irv) {
            cwL();
        } else if (view == this.iBR) {
            if (TextUtils.isEmpty(this.iCb) || this.iCb.length() < 20) {
                l.showToast(this.hSW, R.string.other_comment_size_short_tip);
            } else if (this.iCb.length() > 500) {
                l.showToast(this.hSW, R.string.other_comment_size_long_tip);
            } else {
                this.iBT.a(this.iCb.toString(), cwP(), this.iBQ);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.iBY.setVisibility(8);
            return;
        }
        this.iBY.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eEU), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.iBY.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwO() {
        if (!TextUtils.isEmpty(this.iCb) && this.iCb.length() >= 20 && this.iCb.length() <= 500) {
            this.iBR.setAlpha(1.0f);
        } else {
            this.iBR.setAlpha(0.5f);
        }
    }

    private String cwP() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.eEJ.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hHK, R.color.cp_cont_b);
        ap.setViewTextColor(this.iBY, R.color.cp_cont_d);
        this.eEJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.iBZ, R.color.cp_cont_b);
        this.iBZ.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setViewTextColor(this.iCa, R.color.cp_cont_h);
        if (this.iBX != null) {
            this.iBX.setPlaceHolder(2);
            this.iBX.invalidate();
        }
    }
}
