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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.R;
import com.baidu.tieba.write.j;
/* loaded from: classes2.dex */
public class b {
    private View jvB;
    private View jvC;
    private TextView jvD;
    private TextView jvE;
    private TextView jvF;
    private ImageView jvG;
    private EditText jvH;
    private SpanGroupEditText jvI;
    private a jvJ;
    private boolean jvK;
    private Context mContext;
    private View.OnClickListener onClickListener;
    private View rootView;

    /* loaded from: classes2.dex */
    public interface a {
        void cKf();
    }

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.jvB = this.rootView.findViewById(R.id.item_divider);
        this.jvE = (TextView) this.rootView.findViewById(R.id.item_title_index);
        this.jvG = (ImageView) this.rootView.findViewById(R.id.item_del);
        this.jvH = (EditText) this.rootView.findViewById(R.id.item_title);
        this.jvD = (TextView) this.rootView.findViewById(R.id.item_title_number);
        this.jvC = this.rootView.findViewById(R.id.titile_divider);
        this.jvI = (SpanGroupEditText) this.rootView.findViewById(R.id.item_content);
        this.jvF = (TextView) this.rootView.findViewById(R.id.item_content_number);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jvD, 0, 30);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jvF, 0, 300);
        this.jvH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jvD, editable.toString().length(), 30);
                if (b.this.jvJ != null) {
                    b.this.jvJ.cKf();
                }
                if (b.this.jvK) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(b.this.jvH).pC(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.bv(b.this.jvI).pC(R.color.CAM_X0105);
                    b.this.jvK = false;
                }
            }
        });
        this.jvI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jvF, editable.toString().length(), 300);
                if (b.this.jvJ != null) {
                    b.this.jvJ.cKf();
                }
                if (b.this.jvK) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(b.this.jvH).pC(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.bv(b.this.jvI).pC(R.color.CAM_X0105);
                    b.this.jvK = false;
                }
                if (b.this.jvI.getLineCount() > 6) {
                    b.this.jvI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.2.1
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
                    b.this.jvI.setOnTouchListener(null);
                }
            }
        });
        this.jvH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jvH);
            }
        });
        this.jvI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jvI);
            }
        });
        bxO();
        this.jvI.byA();
    }

    private void bxO() {
        if (this.rootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvB).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvC).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvE).pC(R.color.CAM_X0107).pE(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvD).pC(R.color.CAM_X0111);
            this.jvG.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ao.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jvI.setHintTextColor(ao.getColor(R.color.CAM_X0111));
            this.jvI.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jvH.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jvH.setHintTextColor(ao.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                j.h(this.jvH, R.drawable.edittext_cursor);
                j.h(this.jvI, R.drawable.edittext_cursor);
                return;
            }
            j.h(this.jvH, R.drawable.edittext_cursor_1);
            j.h(this.jvI, R.drawable.edittext_cursor_1);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public SpanGroupEditText cKg() {
        return this.jvI;
    }

    public EditText cKh() {
        return this.jvH;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.jvG.setOnClickListener(this.onClickListener);
    }

    public void a(a aVar) {
        this.jvJ = aVar;
    }

    public void AX(int i) {
        if (this.jvE != null) {
            this.jvE.setText(String.format(this.mContext.getString(R.string.forum_rule_title_index), AY(i)));
        }
    }

    public void rd(boolean z) {
        this.jvK = z;
    }

    private String AY(int i) {
        return com.baidu.tieba.frs.forumRule.d.a.AU(i + 5);
    }
}
