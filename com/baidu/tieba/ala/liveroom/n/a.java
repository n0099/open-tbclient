package com.baidu.tieba.ala.liveroom.n;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class a extends Dialog implements View.OnClickListener {
    private boolean agL;
    private String agM;
    private TextView bIb;
    private b emA;
    private TextView emu;
    private TextView emv;
    private TextView emw;
    private View emx;
    private View emy;
    private PersonUserData emz;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0361a {
        void onConfirm();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void aVC();

        void onCancel();

        void tU(String str);

        void tV(String str);

        void tW(String str);

        void tX(String str);

        void tY(String str);

        void tZ(String str);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.j.theme_manage_dialog);
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.emu = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.emx = findViewById(a.g.ala_person_forbid_this_divider);
        this.emv = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.emy = findViewById(a.g.ala_person_forbid_this_divider);
        this.emw = (TextView) findViewById(a.g.ala_person_admin);
        this.bIb = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.emu.setOnClickListener(this);
        this.emv.setOnClickListener(this);
        this.emw.setOnClickListener(this);
        this.bIb.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.emA != null) {
            if (view == this.emu) {
                if (this.emz != null && this.emz.user_info != null) {
                    if (aVw()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0361a() { // from class: com.baidu.tieba.ala.liveroom.n.a.1
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0361a
                            public void onConfirm() {
                                if (a.this.emz != null && a.this.emz.user_info != null) {
                                    a.this.emz.user_info.is_block = 0;
                                    a.this.emA.tW(a.this.emz.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.emz.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0361a() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
                        @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0361a
                        public void onConfirm() {
                            if (a.this.emz != null && a.this.emz.user_info != null) {
                                a.this.emz.user_info.is_block = 1;
                                a.this.emA.tU(a.this.emz.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.emz.user_info.getNameShow()));
                }
            } else if (view == this.emv) {
                if (this.emz != null && this.emz.user_info != null) {
                    if (aVv()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0361a() { // from class: com.baidu.tieba.ala.liveroom.n.a.3
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0361a
                            public void onConfirm() {
                                if (a.this.emz != null && a.this.emz.user_info != null) {
                                    a.this.emz.user_info.is_block = 0;
                                    a.this.emA.tX(a.this.emz.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.emz.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0361a() { // from class: com.baidu.tieba.ala.liveroom.n.a.4
                        @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0361a
                        public void onConfirm() {
                            if (a.this.emz != null && a.this.emz.user_info != null) {
                                a.this.emz.user_info.is_block = 2;
                                a.this.emA.tV(a.this.emz.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.emz.user_info.getNameShow()));
                }
            } else if (view == this.emw) {
                if (this.emz != null && this.emz.login_user_info != null) {
                    if (aVx()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0361a() { // from class: com.baidu.tieba.ala.liveroom.n.a.5
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0361a
                            public void onConfirm() {
                                if (a.this.emz != null && a.this.emz.login_user_info != null) {
                                    a.this.emz.login_user_info.is_live_admin = 1;
                                    a.this.emA.tY(a.this.emz.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.emz.user_info.getNameShow()));
                    } else if (aVy()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0361a() { // from class: com.baidu.tieba.ala.liveroom.n.a.6
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0361a
                            public void onConfirm() {
                                if (a.this.emz != null && a.this.emz.login_user_info != null) {
                                    a.this.emz.login_user_info.is_live_admin = 0;
                                    a.this.emA.tZ(a.this.emz.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.emz.user_info.getNameShow()));
                    } else if (aVz()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0361a() { // from class: com.baidu.tieba.ala.liveroom.n.a.7
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0361a
                            public void onConfirm() {
                                if (a.this.emz != null && a.this.emz.login_user_info != null) {
                                    a.this.emz.login_user_info.is_live_admin = 0;
                                    a.this.emA.aVC();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bIb) {
                this.emA.onCancel();
            }
        }
    }

    private void a(final InterfaceC0361a interfaceC0361a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0361a != null) {
                    interfaceC0361a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mPageContext).show();
    }

    public void a(PersonUserData personUserData, boolean z, String str) {
        super.show();
        if (personUserData != null) {
            b(personUserData, z, str);
        }
    }

    public void b(PersonUserData personUserData, boolean z, String str) {
        this.emz = personUserData;
        this.agL = z;
        this.agM = str;
        if (aVA() || aVB()) {
            nX(8);
            nY(8);
        } else if (aVv()) {
            nX(8);
            this.emv.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (aVw()) {
            nX(0);
            this.emu.setText(a.i.ala_person_relieve_forbidden_this);
            this.emv.setText(a.i.ala_person_forbid_forever);
        } else {
            nX(0);
            this.emu.setText(a.i.ala_person_forbid_this);
            this.emv.setText(a.i.ala_person_forbid_forever);
        }
        if (aVu()) {
            this.emw.setVisibility(8);
            this.emy.setVisibility(8);
        } else if (aVy()) {
            this.emw.setText(a.i.ala_person_fire_admin);
        } else if (aVx()) {
            this.emw.setText(a.i.ala_person_appoint_admin);
        } else if (aVA() && aVz()) {
            this.emw.setText(a.i.ala_person_resign_admin);
        } else {
            this.emw.setVisibility(8);
            this.emy.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.emA = bVar;
    }

    private boolean aVu() {
        return (this.emz == null || this.emz.user_info == null || this.emz.user_info.is_block <= 0) ? false : true;
    }

    private boolean aVv() {
        return (this.emz == null || this.emz.user_info == null || this.emz.user_info.is_block != 2) ? false : true;
    }

    private boolean aVw() {
        return (this.emz == null || this.emz.user_info == null || this.emz.user_info.is_block != 1) ? false : true;
    }

    private boolean aVx() {
        return this.emz != null && this.emz.user_info != null && this.agL && this.emz.user_info.is_live_admin == 0;
    }

    private boolean aVy() {
        return this.emz != null && this.emz.user_info != null && this.agL && this.emz.user_info.is_live_admin == 1;
    }

    private boolean aVz() {
        return (this.emz == null || this.emz.login_user_info == null || this.agL || this.emz.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean aVA() {
        return (this.emz == null || this.emz.user_info == null || TextUtils.isEmpty(this.agM) || !this.agM.equals(this.emz.user_info.user_id)) ? false : true;
    }

    private boolean aVB() {
        return (this.emz == null || this.emz.user_info == null || this.emz.user_info.is_live_admin != 1) ? false : true;
    }

    private void nX(int i) {
        this.emu.setVisibility(i);
        this.emx.setVisibility(i);
    }

    private void nY(int i) {
        this.emv.setVisibility(i);
        this.emy.setVisibility(i);
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mPageContext.getPageActivity());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
