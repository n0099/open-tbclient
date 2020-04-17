package com.baidu.tieba.ala.liveroom.o;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private boolean aMq;
    private String aMr;
    private TextView cWN;
    private TextView fOm;
    private TextView fOn;
    private TextView fOo;
    private View fOp;
    private View fOq;
    private PersonUserData fOr;
    private b fOs;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0499a {
        void onConfirm();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void AR(String str);

        void AS(String str);

        void AT(String str);

        void AU(String str);

        void AV(String str);

        void AW(String str);

        void bzK();

        void onCancel();
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
        this.fOm = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.fOp = findViewById(a.g.ala_person_forbid_this_divider);
        this.fOn = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.fOq = findViewById(a.g.ala_person_forbid_this_divider);
        this.fOo = (TextView) findViewById(a.g.ala_person_admin);
        this.cWN = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.fOm.setOnClickListener(this);
        this.fOn.setOnClickListener(this);
        this.fOo.setOnClickListener(this);
        this.cWN.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.fOs != null) {
            if (view == this.fOm) {
                if (this.fOr != null && this.fOr.user_info != null) {
                    if (bzE()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0499a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0499a
                            public void onConfirm() {
                                if (a.this.fOr != null && a.this.fOr.user_info != null) {
                                    a.this.fOr.user_info.is_block = 0;
                                    a.this.fOs.AT(a.this.fOr.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fOr.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0499a() { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0499a
                        public void onConfirm() {
                            if (a.this.fOr != null && a.this.fOr.user_info != null) {
                                a.this.fOr.user_info.is_block = 1;
                                a.this.fOs.AR(a.this.fOr.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.fOr.user_info.getNameShow()));
                }
            } else if (view == this.fOn) {
                if (this.fOr != null && this.fOr.user_info != null) {
                    if (bzD()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0499a() { // from class: com.baidu.tieba.ala.liveroom.o.a.3
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0499a
                            public void onConfirm() {
                                if (a.this.fOr != null && a.this.fOr.user_info != null) {
                                    a.this.fOr.user_info.is_block = 0;
                                    a.this.fOs.AU(a.this.fOr.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fOr.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0499a() { // from class: com.baidu.tieba.ala.liveroom.o.a.4
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0499a
                        public void onConfirm() {
                            if (a.this.fOr != null && a.this.fOr.user_info != null) {
                                a.this.fOr.user_info.is_block = 2;
                                a.this.fOs.AS(a.this.fOr.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.fOr.user_info.getNameShow()));
                }
            } else if (view == this.fOo) {
                if (this.fOr != null && this.fOr.login_user_info != null) {
                    if (bzF()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0499a() { // from class: com.baidu.tieba.ala.liveroom.o.a.5
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0499a
                            public void onConfirm() {
                                if (a.this.fOr != null && a.this.fOr.login_user_info != null) {
                                    a.this.fOr.login_user_info.is_live_admin = 1;
                                    a.this.fOs.AV(a.this.fOr.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.fOr.user_info.getNameShow()));
                    } else if (bzG()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0499a() { // from class: com.baidu.tieba.ala.liveroom.o.a.6
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0499a
                            public void onConfirm() {
                                if (a.this.fOr != null && a.this.fOr.login_user_info != null) {
                                    a.this.fOr.login_user_info.is_live_admin = 0;
                                    a.this.fOs.AW(a.this.fOr.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.fOr.user_info.getNameShow()));
                    } else if (bzH()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0499a() { // from class: com.baidu.tieba.ala.liveroom.o.a.7
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0499a
                            public void onConfirm() {
                                if (a.this.fOr != null && a.this.fOr.login_user_info != null) {
                                    a.this.fOr.login_user_info.is_live_admin = 0;
                                    a.this.fOs.bzK();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.cWN) {
                this.fOs.onCancel();
            }
        }
    }

    private void a(final InterfaceC0499a interfaceC0499a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0499a != null) {
                    interfaceC0499a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.9
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
        this.fOr = personUserData;
        this.aMq = z;
        this.aMr = str;
        if (bzI() || bzJ()) {
            qV(8);
            qW(8);
        } else if (bzD()) {
            qV(8);
            this.fOn.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bzE()) {
            qV(0);
            this.fOm.setText(a.i.ala_person_relieve_forbidden_this);
            this.fOn.setText(a.i.ala_person_forbid_forever);
        } else {
            qV(0);
            this.fOm.setText(a.i.ala_person_forbid_this);
            this.fOn.setText(a.i.ala_person_forbid_forever);
        }
        if (bzC()) {
            this.fOo.setVisibility(8);
            this.fOq.setVisibility(8);
        } else if (bzG()) {
            this.fOo.setText(a.i.ala_person_fire_admin);
        } else if (bzF()) {
            this.fOo.setText(a.i.ala_person_appoint_admin);
        } else if (bzI() && bzH()) {
            this.fOo.setText(a.i.ala_person_resign_admin);
        } else {
            this.fOo.setVisibility(8);
            this.fOq.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.fOs = bVar;
    }

    private boolean bzC() {
        return (this.fOr == null || this.fOr.user_info == null || this.fOr.user_info.is_block <= 0) ? false : true;
    }

    private boolean bzD() {
        return (this.fOr == null || this.fOr.user_info == null || this.fOr.user_info.is_block != 2) ? false : true;
    }

    private boolean bzE() {
        return (this.fOr == null || this.fOr.user_info == null || this.fOr.user_info.is_block != 1) ? false : true;
    }

    private boolean bzF() {
        return this.fOr != null && this.fOr.user_info != null && this.aMq && this.fOr.user_info.is_live_admin == 0;
    }

    private boolean bzG() {
        return this.fOr != null && this.fOr.user_info != null && this.aMq && this.fOr.user_info.is_live_admin == 1;
    }

    private boolean bzH() {
        return (this.fOr == null || this.fOr.login_user_info == null || this.aMq || this.fOr.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bzI() {
        return (this.fOr == null || this.fOr.user_info == null || TextUtils.isEmpty(this.aMr) || !this.aMr.equals(this.fOr.user_info.user_id)) ? false : true;
    }

    private boolean bzJ() {
        return (this.fOr == null || this.fOr.user_info == null || this.fOr.user_info.is_live_admin != 1) ? false : true;
    }

    private void qV(int i) {
        this.fOm.setVisibility(i);
        this.fOp.setVisibility(i);
    }

    private void qW(int i) {
        this.fOn.setVisibility(i);
        this.fOq.setVisibility(i);
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
