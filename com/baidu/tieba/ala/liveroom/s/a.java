package com.baidu.tieba.ala.liveroom.s;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aDE;
    private TextView bOb;
    private boolean bja;
    private View hrA;
    private View hrB;
    private PersonUserData hrC;
    private b hrD;
    private TextView hrx;
    private TextView hry;
    private TextView hrz;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0683a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void HR(String str);

        void HS(String str);

        void HT(String str);

        void HU(String str);

        void HV(String str);

        void HW(String str);

        void cgr();

        void onCancel();
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.i.theme_manage_dialog);
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hrx = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hrA = findViewById(a.f.ala_person_forbid_this_divider);
        this.hry = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hrB = findViewById(a.f.ala_person_forbid_this_divider);
        this.hrz = (TextView) findViewById(a.f.ala_person_admin);
        this.bOb = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hrx.setOnClickListener(this);
        this.hry.setOnClickListener(this);
        this.hrz.setOnClickListener(this);
        this.bOb.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hrD != null) {
            if (view == this.hrx) {
                if (this.hrC != null && this.hrC.user_info != null) {
                    if (cgl()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0683a() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0683a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                    a.this.hrC.user_info.is_block = 0;
                                    a.this.hrD.HT(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hrC.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0683a() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
                        @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0683a
                        public void onConfirm() {
                            if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                a.this.hrC.user_info.is_block = 1;
                                a.this.hrD.HR(a.this.hrC.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_this_confirm_tip), this.hrC.user_info.getNameShow()));
                }
            } else if (view == this.hry) {
                if (this.hrC != null && this.hrC.user_info != null) {
                    if (cgk()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0683a() { // from class: com.baidu.tieba.ala.liveroom.s.a.3
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0683a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                    a.this.hrC.user_info.is_block = 0;
                                    a.this.hrD.HU(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hrC.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0683a() { // from class: com.baidu.tieba.ala.liveroom.s.a.4
                        @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0683a
                        public void onConfirm() {
                            if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                a.this.hrC.user_info.is_block = 2;
                                a.this.hrD.HS(a.this.hrC.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_forever_confirm_tip), this.hrC.user_info.getNameShow()));
                }
            } else if (view == this.hrz) {
                if (this.hrC != null && this.hrC.login_user_info != null) {
                    if (cgm()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0683a() { // from class: com.baidu.tieba.ala.liveroom.s.a.5
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0683a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.login_user_info != null) {
                                    a.this.hrC.login_user_info.is_live_admin = 1;
                                    a.this.hrD.HV(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_appoint_admin_confirm_tip), this.hrC.user_info.getNameShow()));
                    } else if (cgn()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0683a() { // from class: com.baidu.tieba.ala.liveroom.s.a.6
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0683a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.login_user_info != null) {
                                    a.this.hrC.login_user_info.is_live_admin = 0;
                                    a.this.hrD.HW(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_fire_admin_confirm_tip), this.hrC.user_info.getNameShow()));
                    } else if (cgo()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0683a() { // from class: com.baidu.tieba.ala.liveroom.s.a.7
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0683a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.login_user_info != null) {
                                    a.this.hrC.login_user_info.is_live_admin = 0;
                                    a.this.hrD.cgr();
                                }
                            }
                        }, getContext().getResources().getString(a.h.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bOb) {
                this.hrD.onCancel();
            }
        }
    }

    private void a(final InterfaceC0683a interfaceC0683a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0683a != null) {
                    interfaceC0683a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.9
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
        this.hrC = personUserData;
        this.bja = z;
        this.aDE = str;
        if (cgp() || cgq()) {
            wH(8);
            wI(8);
        } else if (cgk()) {
            wH(8);
            this.hry.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (cgl()) {
            wH(0);
            this.hrx.setText(a.h.ala_person_relieve_forbidden_this);
            this.hry.setText(a.h.ala_person_forbid_forever);
        } else {
            wH(0);
            this.hrx.setText(a.h.ala_person_forbid_this);
            this.hry.setText(a.h.ala_person_forbid_forever);
        }
        if (cgj()) {
            this.hrz.setVisibility(8);
            this.hrB.setVisibility(8);
        } else if (cgn()) {
            this.hrz.setText(a.h.ala_person_fire_admin);
        } else if (cgm()) {
            this.hrz.setText(a.h.ala_person_appoint_admin);
        } else if (cgp() && cgo()) {
            this.hrz.setText(a.h.ala_person_resign_admin);
        } else {
            this.hrz.setVisibility(8);
            this.hrB.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hrD = bVar;
    }

    private boolean cgj() {
        return (this.hrC == null || this.hrC.user_info == null || this.hrC.user_info.is_block <= 0) ? false : true;
    }

    private boolean cgk() {
        return (this.hrC == null || this.hrC.user_info == null || this.hrC.user_info.is_block != 2) ? false : true;
    }

    private boolean cgl() {
        return (this.hrC == null || this.hrC.user_info == null || this.hrC.user_info.is_block != 1) ? false : true;
    }

    private boolean cgm() {
        return this.hrC != null && this.hrC.user_info != null && this.bja && this.hrC.user_info.is_live_admin == 0;
    }

    private boolean cgn() {
        return this.hrC != null && this.hrC.user_info != null && this.bja && this.hrC.user_info.is_live_admin == 1;
    }

    private boolean cgo() {
        return (this.hrC == null || this.hrC.login_user_info == null || this.bja || this.hrC.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean cgp() {
        return (this.hrC == null || this.hrC.user_info == null || TextUtils.isEmpty(this.aDE) || !this.aDE.equals(this.hrC.user_info.user_id)) ? false : true;
    }

    private boolean cgq() {
        return (this.hrC == null || this.hrC.user_info == null || this.hrC.user_info.is_live_admin != 1) ? false : true;
    }

    private void wH(int i) {
        this.hrx.setVisibility(i);
        this.hrA.setVisibility(i);
    }

    private void wI(int i) {
        this.hry.setVisibility(i);
        this.hrB.setVisibility(i);
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
