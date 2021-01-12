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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends a {
    private static final int fep = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int feq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fer = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fes = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fet = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int feu = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int few = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private View dyW;
    private RankStarView feh;
    private TextView itr;
    private TbImageView jnU;
    private TextView jnV;
    private EditText jnW;
    private TextView jnX;
    private Editable jnY;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iEK).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jnU = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.itr = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.jnV = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.dyW = this.mRoot.findViewById(R.id.divider);
        this.feh = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.jnW = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.jnX = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.jnU.setPlaceHolder(2);
        this.jnU.setConrers(15);
        this.jnU.setRadius(l.getDimens(this.iEK, R.dimen.tbds10));
        this.feh.setStarSpacing(l.getDimens(this.iEK, R.dimen.tbds24));
        this.feh.setClickable(true);
        this.jnW.setLineSpacing(l.getDimens(this.iEK, R.dimen.tbds16), 1.0f);
        if (this.jnP != null) {
            setTag(this.jnP.getTags());
            this.itr.setText(this.jnP.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnU.getLayoutParams();
            if (this.jnP.getIconSize() == 1.0d) {
                layoutParams.width = fep;
                layoutParams.height = feq;
            } else if (this.jnP.getIconSize() == 0.67d) {
                layoutParams.width = fer;
                layoutParams.height = fes;
            } else {
                layoutParams.width = fet;
                layoutParams.height = feu;
            }
            this.jnU.setLayoutParams(layoutParams);
            this.jnU.startLoad(this.jnP.icon_url, 10, false);
            if (this.jnP.getScore() != null && this.jnP.getScore().isCommented == 1) {
                this.feh.setStarCount(this.jnP.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.iEK, view);
                    return false;
                }
                return false;
            }
        });
        this.jnQ.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.iEK.HidenSoftKeyPad(inputMethodManager, b.this.jnW);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cFy() {
        this.jdb.setOnClickListener(this);
        this.jnO.setOnClickListener(this);
        this.jnW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.jnY = editable;
                if (b.this.jnY.length() > 500) {
                    b.this.jnX.setText(String.format(b.this.iEK.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.jnY.length())));
                    b.this.jnX.setVisibility(0);
                } else {
                    b.this.jnX.setVisibility(8);
                }
                b.this.cFC();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bBV() {
        if (this.jnN != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.feh.getStarCount());
            writeData.setOtherComment(this.jnW.getText().toString());
            y.g(String.valueOf(this.jnN.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cFA() {
        if (this.jnN != null) {
            y.f(String.valueOf(this.jnN.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        b.this.feh.setStarCount(writeData.getOtherGrade());
                        b.this.jnW.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jdb) {
            cFz();
        } else if (view == this.jnO) {
            if (TextUtils.isEmpty(this.jnY) || this.jnY.length() < 20) {
                l.showToast(this.iEK, R.string.other_comment_size_short_tip);
            } else if (this.jnY.length() > 500) {
                l.showToast(this.iEK, R.string.other_comment_size_long_tip);
            } else {
                this.jnQ.a(this.jnY.toString(), cFD(), this.jnN);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.jnV.setVisibility(8);
            return;
        }
        this.jnV.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(few), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.jnV.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFC() {
        if (!TextUtils.isEmpty(this.jnY) && this.jnY.length() >= 20 && this.jnY.length() <= 500) {
            this.jnO.setAlpha(1.0f);
        } else {
            this.jnO.setAlpha(0.5f);
        }
    }

    private String cFD() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.feh.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
        ao.setViewTextColor(this.itr, R.color.CAM_X0105);
        ao.setViewTextColor(this.jnV, R.color.CAM_X0109);
        this.feh.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ao.setViewTextColor(this.jnW, R.color.CAM_X0105);
        this.jnW.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        ao.setViewTextColor(this.jnX, R.color.CAM_X0301);
        if (this.jnU != null) {
            this.jnU.setPlaceHolder(2);
            this.jnU.invalidate();
        }
    }
}
