package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern arg = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern arj = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean SU;
    private boolean aqO;
    private int arb;
    private aj arc;
    protected PbEditorToolView ard;
    public EditorToolComponetContainer are;
    protected com.baidu.tbadk.editortool.w arf;
    private boolean arh;
    protected boolean ari;
    protected Context mContext;

    public void setHideBaobao(boolean z) {
        this.SU = z;
        if (this.are != null) {
            this.are.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.are;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.ard;
    }

    public PbEditor(Context context) {
        super(context);
        this.arb = 1000;
        this.aqO = false;
        this.SU = false;
        this.ari = true;
        this.mContext = context;
        ny();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arb = 1000;
        this.aqO = false;
        this.SU = false;
        this.ari = true;
        this.mContext = context;
        ny();
    }

    public void setFrom(int i) {
        if (this.are != null) {
            this.are.setFrom(i);
        }
    }

    public void BX() {
        this.ard.BX();
    }

    public void BY() {
        this.ard.BY();
    }

    public boolean BZ() {
        Editable text = this.ard.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.are.BL() || this.are.BM()) {
            return true;
        }
        return this.are.BN();
    }

    public EditText getEditText() {
        return this.ard.getEditText();
    }

    public void o(ArrayList<String> arrayList) {
        this.ard.p(arrayList);
    }

    public String getContent() {
        return this.ard.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.ard.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.ard.getEditText().setSelection(str.length());
        }
    }

    public void Ca() {
        this.ard.getEditText().requestFocus();
        this.are.x(this.ard.getEditText());
    }

    public void Cb() {
        this.are.BC();
        this.ard.Bg();
    }

    public void Cc() {
        this.are.BC();
        this.ard.Bg();
    }

    public void Cd() {
        if (this.are.BB() && !this.arh) {
            this.arh = true;
            ax.a(this, this.mContext, new z(this));
            return;
        }
        Cb();
    }

    public boolean BB() {
        return this.are.BB();
    }

    protected void ny() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.pb_editor_view, this, true);
        this.ard = (PbEditorToolView) findViewById(com.baidu.tieba.v.pb_editor_tool_button);
        this.are = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.pb_editor_tool_group);
    }

    private void Ce() {
        this.arc = new aj(this.mContext);
        this.arc.nz();
        addView(this.arc, 0);
        this.arc.setOnActionListener(this.arf);
    }

    public boolean BS() {
        return this.are.BS();
    }

    public void v(View view) {
        this.are.v(view);
    }

    public void w(View view) {
        this.are.w(view);
    }

    public void Cf() {
        this.ard.getEditText().requestFocus();
        this.are.x(this.ard.getEditText());
        this.ard.getEditText().setSelection(this.ard.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, az azVar) {
        this.ard.getEditText().requestFocus();
        this.are.w(this.ard.getEditText());
        eq(i);
    }

    public void j(int i, String str) {
        if (this.arc != null) {
            this.arc.j(i, str);
            if (i == 2 && this.arc.getVisibility() == 0) {
                this.are.rI();
                this.ard.Cn();
                return;
            }
            Cg();
        }
    }

    private void Cg() {
        if (this.are != null) {
            this.are.rJ();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        j(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.arc == null) {
            return 8;
        }
        return this.arc.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.arc == null) {
            return 0;
        }
        return this.arc.getLocationInfoViewState();
    }

    protected void eq(int i) {
        if (i == 5) {
            this.are.BH();
        } else if (i == 23 || i == 22) {
            this.are.BI();
        } else if (i == 2) {
            this.are.BG();
        } else if (i == 38) {
            this.are.BF();
        } else if (i == 44) {
            this.are.BJ();
        } else if (i == 50 || i == 48) {
            this.are.BK();
        }
    }

    public void er(int i) {
        if (this.are.BB()) {
            eq(i);
            this.are.w(this.ard.getEditText());
            return;
        }
        this.ari = false;
        if (this.are.BS()) {
            this.are.w(this.ard.getEditText());
        }
        new Handler().postDelayed(new aa(this, i), 200L);
    }

    public boolean Ch() {
        Editable text = this.ard.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.arb;
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.arf = wVar;
            if (this.arc != null) {
                this.arc.setOnActionListener(wVar);
            }
            this.ard.setOnActionListener(new ac(this, wVar));
            this.are.setOnActionListener(new ad(this, wVar));
        }
    }

    public void BO() {
        this.are.BO();
    }

    public void changeSkinType(int i) {
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this.ard);
            ((BaseActivity) this.mContext).getLayoutMode().h(this.are);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this.ard);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this.are);
        }
        if (this.arc != null) {
            this.arc.nz();
        }
        this.ard.changeSkinType(i);
        this.are.onChangeSkinType(i);
    }

    public void clearData() {
        this.ard.clearData();
        this.are.clearData();
    }

    public void BE() {
        this.are.BE();
    }

    public void Ba() {
        if (this.arf != null) {
            this.arf.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.arf != null) {
            this.arf.handleAction(34, null);
        }
        this.ard.Bg();
        this.are.BC();
        w(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.ard.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.ard.setAudioFocusable(z);
    }

    public void Bt() {
        this.ard.Bt();
    }

    public void Bs() {
        this.ard.Bs();
    }

    public void BQ() {
        this.are.BQ();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.are.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.are.setAudioData(voiceModel);
    }

    public void BP() {
        this.are.BP();
    }

    public void h(Bitmap bitmap) {
        this.are.setImage(bitmap);
    }

    public void au(boolean z) {
        this.aqO = z;
        this.are.au(z);
        if (z) {
            setLocationViewVisibility(8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int eI(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = arj.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.aa.rz().cY(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.aqO) {
            this.ard.Co();
            return;
        }
        if (TextUtils.isEmpty(TbadkApplication.m251getInst().getDefaultBubble()) && !this.aqO) {
            if (!this.are.BL() && !this.are.BM() && !this.are.rH()) {
                this.ard.Co();
            } else {
                this.ard.Cn();
            }
        } else {
            this.ard.Cn();
        }
        this.are.refresh();
    }

    public void setMaxTextCount(int i) {
        this.arb = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.arc == null) {
                Ce();
            }
            this.arc.setVisibility(0);
            return;
        }
        if (this.arc != null) {
            removeView(this.arc);
            this.arc = null;
        }
        Cg();
    }
}
