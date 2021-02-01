package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.R;
import com.baidu.tieba.write.j;
/* loaded from: classes2.dex */
public class b {
    private View jwB;
    private View jwC;
    private TextView jwD;
    private TextView jwE;
    private TextView jwF;
    private ImageView jwG;
    private EditText jwH;
    private SpanGroupEditText jwI;
    private a jwJ;
    private boolean jwK;
    private Context mContext;
    private View.OnClickListener onClickListener;
    private View rootView;

    /* loaded from: classes2.dex */
    public interface a {
        void cHB();
    }

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.jwB = this.rootView.findViewById(R.id.item_divider);
        this.jwE = (TextView) this.rootView.findViewById(R.id.item_title_index);
        this.jwG = (ImageView) this.rootView.findViewById(R.id.item_del);
        this.jwH = (EditText) this.rootView.findViewById(R.id.item_title);
        this.jwD = (TextView) this.rootView.findViewById(R.id.item_title_number);
        this.jwC = this.rootView.findViewById(R.id.titile_divider);
        this.jwI = (SpanGroupEditText) this.rootView.findViewById(R.id.item_content);
        this.jwF = (TextView) this.rootView.findViewById(R.id.item_content_number);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jwD, 0, 30);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jwF, 0, 300);
        this.jwH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jwD, editable.toString().length(), 30);
                if (b.this.jwJ != null) {
                    b.this.jwJ.cHB();
                }
                if (b.this.jwK) {
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jwH).nY(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jwI).nY(R.color.CAM_X0105);
                    b.this.jwK = false;
                }
            }
        });
        this.jwI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jwF, editable.toString().length(), 300);
                if (b.this.jwJ != null) {
                    b.this.jwJ.cHB();
                }
                if (b.this.jwK) {
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jwH).nY(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jwI).nY(R.color.CAM_X0105);
                    b.this.jwK = false;
                }
                if (b.this.jwI.getLineCount() > 6) {
                    b.this.jwI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.2.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 0) {
                                view.getParent().requestDisallowInterceptTouchEvent(true);
                            } else if (motionEvent.getAction() == 1) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            } else if (motionEvent.getAction() == 3) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            }
                            return false;
                        }
                    });
                } else {
                    b.this.jwI.setOnTouchListener(null);
                }
            }
        });
        this.jwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jwH);
            }
        });
        this.jwI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jwI);
            }
        });
        bup();
        this.jwI.bvb();
    }

    private void bup() {
        if (this.rootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwB).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwC).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwE).nY(R.color.CAM_X0107).oa(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwD).nY(R.color.CAM_X0111);
            this.jwG.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jwI.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jwI.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jwH.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jwH.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                j.h(this.jwH, R.drawable.edittext_cursor);
                j.h(this.jwI, R.drawable.edittext_cursor);
                return;
            }
            j.h(this.jwH, R.drawable.edittext_cursor_1);
            j.h(this.jwI, R.drawable.edittext_cursor_1);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public SpanGroupEditText cHC() {
        return this.jwI;
    }

    public EditText cHD() {
        return this.jwH;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.jwG.setOnClickListener(this.onClickListener);
    }

    public void a(a aVar) {
        this.jwJ = aVar;
    }

    public void zB(int i) {
        if (this.jwE != null) {
            this.jwE.setText(String.format(this.mContext.getString(R.string.forum_rule_title_index), zC(i)));
        }
    }

    public void rj(boolean z) {
        this.jwK = z;
    }

    private String zC(int i) {
        return com.baidu.tieba.frs.forumRule.d.a.zy(i + 5);
    }
}
