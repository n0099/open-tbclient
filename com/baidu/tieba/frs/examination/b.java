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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b extends a {
    private RankStarView eqp;
    private TextView hlJ;
    private TbImageView ifW;
    private TextView ifX;
    private EditText ifY;
    private TextView ifZ;
    private Editable iga;
    private View mDivider;
    private static final int equ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqw = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eqx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqy = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int eqA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hwQ).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.ifW = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.hlJ = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.ifX = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.eqp = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.ifY = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.ifZ = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.ifW.setPlaceHolder(2);
        this.ifW.setConrers(15);
        this.ifW.setRadius(l.getDimens(this.hwQ, R.dimen.tbds10));
        this.eqp.setStarSpacing(l.getDimens(this.hwQ, R.dimen.tbds24));
        this.eqp.setClickable(true);
        this.ifY.setLineSpacing(l.getDimens(this.hwQ, R.dimen.tbds16), 1.0f);
        if (this.ifR != null) {
            setTag(this.ifR.getTags());
            this.hlJ.setText(this.ifR.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifW.getLayoutParams();
            if (this.ifR.getIconSize() == 1.0d) {
                layoutParams.width = equ;
                layoutParams.height = eqv;
            } else if (this.ifR.getIconSize() == 0.67d) {
                layoutParams.width = eqw;
                layoutParams.height = eqx;
            } else {
                layoutParams.width = eqy;
                layoutParams.height = eqz;
            }
            this.ifW.setLayoutParams(layoutParams);
            this.ifW.startLoad(this.ifR.icon_url, 10, false);
            if (this.ifR.getScore() != null && this.ifR.getScore().isCommented == 1) {
                this.eqp.setStarCount(this.ifR.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.hwQ, view);
                    return false;
                }
                return false;
            }
        });
        this.ifS.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.hwQ.HidenSoftKeyPad(inputMethodManager, b.this.ifY);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cpZ() {
        this.hVo.setOnClickListener(this);
        this.ifQ.setOnClickListener(this);
        this.ifY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.iga = editable;
                if (b.this.iga.length() > 500) {
                    b.this.ifZ.setText(String.format(b.this.hwQ.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.iga.length())));
                    b.this.ifZ.setVisibility(0);
                } else {
                    b.this.ifZ.setVisibility(8);
                }
                b.this.cqd();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bsv() {
        if (this.ifP != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.eqp.getStarCount());
            writeData.setOtherComment(this.ifY.getText().toString());
            x.c(String.valueOf(this.ifP.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cqb() {
        if (this.ifP != null) {
            x.f(String.valueOf(this.ifP.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.eqp.setStarCount(writeData.getOtherGrade());
                        b.this.ifY.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVo) {
            cqa();
        } else if (view == this.ifQ) {
            if (TextUtils.isEmpty(this.iga) || this.iga.length() < 20) {
                l.showToast(this.hwQ, R.string.other_comment_size_short_tip);
            } else if (this.iga.length() > 500) {
                l.showToast(this.hwQ, R.string.other_comment_size_long_tip);
            } else {
                this.ifS.a(this.iga.toString(), cqe(), this.ifP);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.ifX.setVisibility(8);
            return;
        }
        this.ifX.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eqA), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.ifX.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqd() {
        if (!TextUtils.isEmpty(this.iga) && this.iga.length() >= 20 && this.iga.length() <= 500) {
            this.ifQ.setAlpha(1.0f);
        } else {
            this.ifQ.setAlpha(0.5f);
        }
    }

    private String cqe() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new u("", String.valueOf(this.eqp.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hlJ, R.color.cp_cont_b);
        ap.setViewTextColor(this.ifX, R.color.cp_cont_d);
        this.eqp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.ifY, R.color.cp_cont_b);
        this.ifY.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setViewTextColor(this.ifZ, R.color.cp_cont_h);
        if (this.ifW != null) {
            this.ifW.setPlaceHolder(2);
            this.ifW.invalidate();
        }
    }
}
