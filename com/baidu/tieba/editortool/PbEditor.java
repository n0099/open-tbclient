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
    private static final Pattern arp = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern ars = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean SY;
    private boolean aqX;
    private int ark;
    private aj arl;
    protected PbEditorToolView arm;
    public EditorToolComponetContainer arn;
    protected com.baidu.tbadk.editortool.w aro;
    private boolean arq;
    protected boolean arr;
    protected Context mContext;

    public void setHideBaobao(boolean z) {
        this.SY = z;
        if (this.arn != null) {
            this.arn.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.arn;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.arm;
    }

    public PbEditor(Context context) {
        super(context);
        this.ark = 1000;
        this.aqX = false;
        this.SY = false;
        this.arr = true;
        this.mContext = context;
        ny();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ark = 1000;
        this.aqX = false;
        this.SY = false;
        this.arr = true;
        this.mContext = context;
        ny();
    }

    public void setFrom(int i) {
        if (this.arn != null) {
            this.arn.setFrom(i);
        }
    }

    public void BZ() {
        this.arm.BZ();
    }

    public void Ca() {
        this.arm.Ca();
    }

    public boolean Cb() {
        Editable text = this.arm.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.arn.BN() || this.arn.BO()) {
            return true;
        }
        return this.arn.BP();
    }

    public EditText getEditText() {
        return this.arm.getEditText();
    }

    public void p(ArrayList<String> arrayList) {
        this.arm.q(arrayList);
    }

    public String getContent() {
        return this.arm.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.arm.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.arm.getEditText().setSelection(str.length());
        }
    }

    public void Cc() {
        this.arm.getEditText().requestFocus();
        this.arn.x(this.arm.getEditText());
    }

    public void Cd() {
        this.arn.BE();
        this.arm.Bi();
    }

    public void Ce() {
        this.arn.BE();
        this.arm.Bi();
    }

    public void Cf() {
        if (this.arn.BD() && !this.arq) {
            this.arq = true;
            ax.a(this, this.mContext, new z(this));
            return;
        }
        Cd();
    }

    public boolean BD() {
        return this.arn.BD();
    }

    protected void ny() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.pb_editor_view, this, true);
        this.arm = (PbEditorToolView) findViewById(com.baidu.tieba.v.pb_editor_tool_button);
        this.arn = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.pb_editor_tool_group);
    }

    private void Cg() {
        this.arl = new aj(this.mContext);
        this.arl.nz();
        addView(this.arl, 0);
        this.arl.setOnActionListener(this.aro);
    }

    public boolean BU() {
        return this.arn.BU();
    }

    public void v(View view) {
        this.arn.v(view);
    }

    public void w(View view) {
        this.arn.w(view);
    }

    public void Ch() {
        this.arm.getEditText().requestFocus();
        this.arn.x(this.arm.getEditText());
        this.arm.getEditText().setSelection(this.arm.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, az azVar) {
        this.arm.getEditText().requestFocus();
        this.arn.w(this.arm.getEditText());
        eq(i);
    }

    public void j(int i, String str) {
        if (this.arl != null) {
            this.arl.j(i, str);
            if (i == 2 && this.arl.getVisibility() == 0) {
                this.arn.rK();
                this.arm.Cp();
                return;
            }
            Ci();
        }
    }

    private void Ci() {
        if (this.arn != null) {
            this.arn.rL();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        j(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.arl == null) {
            return 8;
        }
        return this.arl.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.arl == null) {
            return 0;
        }
        return this.arl.getLocationInfoViewState();
    }

    protected void eq(int i) {
        if (i == 5) {
            this.arn.BJ();
        } else if (i == 23 || i == 22) {
            this.arn.BK();
        } else if (i == 2) {
            this.arn.BI();
        } else if (i == 38) {
            this.arn.BH();
        } else if (i == 44) {
            this.arn.BL();
        } else if (i == 50 || i == 48) {
            this.arn.BM();
        }
    }

    public void er(int i) {
        if (this.arn.BD()) {
            eq(i);
            this.arn.w(this.arm.getEditText());
            return;
        }
        this.arr = false;
        if (this.arn.BU()) {
            this.arn.w(this.arm.getEditText());
        }
        new Handler().postDelayed(new aa(this, i), 200L);
    }

    public boolean Cj() {
        Editable text = this.arm.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.ark;
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aro = wVar;
            if (this.arl != null) {
                this.arl.setOnActionListener(wVar);
            }
            this.arm.setOnActionListener(new ac(this, wVar));
            this.arn.setOnActionListener(new ad(this, wVar));
        }
    }

    public void BQ() {
        this.arn.BQ();
    }

    public void changeSkinType(int i) {
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this.arm);
            ((BaseActivity) this.mContext).getLayoutMode().h(this.arn);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this.arm);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this.arn);
        }
        if (this.arl != null) {
            this.arl.nz();
        }
        this.arm.changeSkinType(i);
        this.arn.onChangeSkinType(i);
    }

    public void clearData() {
        this.arm.clearData();
        this.arn.clearData();
    }

    public void BG() {
        this.arn.BG();
    }

    public void Bc() {
        if (this.aro != null) {
            this.aro.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.aro != null) {
            this.aro.handleAction(34, null);
        }
        this.arm.Bi();
        this.arn.BE();
        w(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.arm.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.arm.setAudioFocusable(z);
    }

    public void Bv() {
        this.arm.Bv();
    }

    public void Bu() {
        this.arm.Bu();
    }

    public void BS() {
        this.arn.BS();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.arn.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.arn.setAudioData(voiceModel);
    }

    public void BR() {
        this.arn.BR();
    }

    public void h(Bitmap bitmap) {
        this.arn.setImage(bitmap);
    }

    public void au(boolean z) {
        this.aqX = z;
        this.arn.au(z);
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
            Matcher matcher = ars.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.aa.rB().cY(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.aqX) {
            this.arm.Cq();
            return;
        }
        if (TextUtils.isEmpty(TbadkApplication.m251getInst().getDefaultBubble()) && !this.aqX) {
            if (!this.arn.BN() && !this.arn.BO() && !this.arn.rJ()) {
                this.arm.Cq();
            } else {
                this.arm.Cp();
            }
        } else {
            this.arm.Cp();
        }
        this.arn.refresh();
    }

    public void setMaxTextCount(int i) {
        this.ark = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.arl == null) {
                Cg();
            }
            this.arl.setVisibility(0);
            return;
        }
        if (this.arl != null) {
            removeView(this.arl);
            this.arl = null;
        }
        Ci();
    }
}
