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
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends a {
    private static final int fgF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fgI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int fgM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private View dBb;
    private RankStarView fgw;
    private TextView izp;
    private TbImageView jtO;
    private TextView jtP;
    private EditText jtQ;
    private TextView jtR;
    private Editable jtS;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iKH).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jtO = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.izp = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.jtP = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.dBb = this.mRoot.findViewById(R.id.divider);
        this.fgw = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.jtQ = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.jtR = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.jtO.setPlaceHolder(2);
        this.jtO.setConrers(15);
        this.jtO.setRadius(l.getDimens(this.iKH, R.dimen.tbds10));
        this.fgw.setStarSpacing(l.getDimens(this.iKH, R.dimen.tbds24));
        this.fgw.setClickable(true);
        this.jtQ.setLineSpacing(l.getDimens(this.iKH, R.dimen.tbds16), 1.0f);
        if (this.jtJ != null) {
            setTag(this.jtJ.getTags());
            this.izp.setText(this.jtJ.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jtO.getLayoutParams();
            if (this.jtJ.getIconSize() == 1.0d) {
                layoutParams.width = fgF;
                layoutParams.height = fgG;
            } else if (this.jtJ.getIconSize() == 0.67d) {
                layoutParams.width = fgH;
                layoutParams.height = fgI;
            } else {
                layoutParams.width = fgJ;
                layoutParams.height = fgK;
            }
            this.jtO.setLayoutParams(layoutParams);
            this.jtO.startLoad(this.jtJ.icon_url, 10, false);
            if (this.jtJ.getScore() != null && this.jtJ.getScore().isCommented == 1) {
                this.fgw.setStarCount(this.jtJ.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.iKH, view);
                    return false;
                }
                return false;
            }
        });
        this.jtK.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.iKH.HidenSoftKeyPad(inputMethodManager, b.this.jtQ);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGS() {
        this.jiW.setOnClickListener(this);
        this.jtI.setOnClickListener(this);
        this.jtQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.jtS = editable;
                if (b.this.jtS.length() > 500) {
                    b.this.jtR.setText(String.format(b.this.iKH.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.jtS.length())));
                    b.this.jtR.setVisibility(0);
                } else {
                    b.this.jtR.setVisibility(8);
                }
                b.this.cGW();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bCn() {
        if (this.jtH != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.fgw.getStarCount());
            writeData.setOtherComment(this.jtQ.getText().toString());
            y.g(String.valueOf(this.jtH.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cGU() {
        if (this.jtH != null) {
            y.f(String.valueOf(this.jtH.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        b.this.fgw.setStarCount(writeData.getOtherGrade());
                        b.this.jtQ.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiW) {
            cGT();
        } else if (view == this.jtI) {
            if (TextUtils.isEmpty(this.jtS) || this.jtS.length() < 20) {
                l.showToast(this.iKH, R.string.other_comment_size_short_tip);
            } else if (this.jtS.length() > 500) {
                l.showToast(this.iKH, R.string.other_comment_size_long_tip);
            } else {
                this.jtK.a(this.jtS.toString(), cGX(), this.jtH);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.jtP.setVisibility(8);
            return;
        }
        this.jtP.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(fgM), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.jtP.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGW() {
        if (!TextUtils.isEmpty(this.jtS) && this.jtS.length() >= 20 && this.jtS.length() <= 500) {
            this.jtI.setAlpha(1.0f);
        } else {
            this.jtI.setAlpha(0.5f);
        }
    }

    private String cGX() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.fgw.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
        ap.setViewTextColor(this.izp, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtP, R.color.CAM_X0109);
        this.fgw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.jtQ, R.color.CAM_X0105);
        this.jtQ.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        ap.setViewTextColor(this.jtR, R.color.CAM_X0301);
        if (this.jtO != null) {
            this.jtO.setPlaceHolder(2);
            this.jtO.invalidate();
        }
    }
}
