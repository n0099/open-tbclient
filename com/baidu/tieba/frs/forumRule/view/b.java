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
    private TextView jyA;
    private TextView jyB;
    private TextView jyC;
    private ImageView jyD;
    private EditText jyE;
    private SpanGroupEditText jyF;
    private a jyG;
    private boolean jyH;
    private View jyy;
    private View jyz;
    private Context mContext;
    private View.OnClickListener onClickListener;
    private View rootView;

    /* loaded from: classes2.dex */
    public interface a {
        void cHO();
    }

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.jyy = this.rootView.findViewById(R.id.item_divider);
        this.jyB = (TextView) this.rootView.findViewById(R.id.item_title_index);
        this.jyD = (ImageView) this.rootView.findViewById(R.id.item_del);
        this.jyE = (EditText) this.rootView.findViewById(R.id.item_title);
        this.jyA = (TextView) this.rootView.findViewById(R.id.item_title_number);
        this.jyz = this.rootView.findViewById(R.id.titile_divider);
        this.jyF = (SpanGroupEditText) this.rootView.findViewById(R.id.item_content);
        this.jyC = (TextView) this.rootView.findViewById(R.id.item_content_number);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jyA, 0, 30);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jyC, 0, 300);
        this.jyE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jyA, editable.toString().length(), 30);
                if (b.this.jyG != null) {
                    b.this.jyG.cHO();
                }
                if (b.this.jyH) {
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jyE).nZ(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jyF).nZ(R.color.CAM_X0105);
                    b.this.jyH = false;
                }
            }
        });
        this.jyF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jyC, editable.toString().length(), 300);
                if (b.this.jyG != null) {
                    b.this.jyG.cHO();
                }
                if (b.this.jyH) {
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jyE).nZ(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jyF).nZ(R.color.CAM_X0105);
                    b.this.jyH = false;
                }
                if (b.this.jyF.getLineCount() > 6) {
                    b.this.jyF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.2.1
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
                    b.this.jyF.setOnTouchListener(null);
                }
            }
        });
        this.jyE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jyE);
            }
        });
        this.jyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jyF);
            }
        });
        bus();
        this.jyF.bve();
    }

    private void bus() {
        if (this.rootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyy).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyz).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyB).nZ(R.color.CAM_X0107).ob(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyA).nZ(R.color.CAM_X0111);
            this.jyD.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jyF.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jyF.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jyE.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jyE.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                j.h(this.jyE, R.drawable.edittext_cursor);
                j.h(this.jyF, R.drawable.edittext_cursor);
                return;
            }
            j.h(this.jyE, R.drawable.edittext_cursor_1);
            j.h(this.jyF, R.drawable.edittext_cursor_1);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public SpanGroupEditText cHP() {
        return this.jyF;
    }

    public EditText cHQ() {
        return this.jyE;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.jyD.setOnClickListener(this.onClickListener);
    }

    public void a(a aVar) {
        this.jyG = aVar;
    }

    public void zC(int i) {
        if (this.jyB != null) {
            this.jyB.setText(String.format(this.mContext.getString(R.string.forum_rule_title_index), zD(i)));
        }
    }

    public void rj(boolean z) {
        this.jyH = z;
    }

    private String zD(int i) {
        return com.baidu.tieba.frs.forumRule.d.a.zz(i + 5);
    }
}
