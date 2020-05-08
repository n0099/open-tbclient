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
    private boolean aMw;
    private String aMx;
    private TextView cWS;
    private TextView fOr;
    private TextView fOs;
    private TextView fOt;
    private View fOu;
    private View fOv;
    private PersonUserData fOw;
    private b fOx;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0520a {
        void onConfirm();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void AU(String str);

        void AV(String str);

        void AW(String str);

        void AX(String str);

        void AY(String str);

        void AZ(String str);

        void bzI();

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
        this.fOr = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.fOu = findViewById(a.g.ala_person_forbid_this_divider);
        this.fOs = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.fOv = findViewById(a.g.ala_person_forbid_this_divider);
        this.fOt = (TextView) findViewById(a.g.ala_person_admin);
        this.cWS = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.fOr.setOnClickListener(this);
        this.fOs.setOnClickListener(this);
        this.fOt.setOnClickListener(this);
        this.cWS.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.fOx != null) {
            if (view == this.fOr) {
                if (this.fOw != null && this.fOw.user_info != null) {
                    if (bzC()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0520a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0520a
                            public void onConfirm() {
                                if (a.this.fOw != null && a.this.fOw.user_info != null) {
                                    a.this.fOw.user_info.is_block = 0;
                                    a.this.fOx.AW(a.this.fOw.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fOw.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0520a() { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0520a
                        public void onConfirm() {
                            if (a.this.fOw != null && a.this.fOw.user_info != null) {
                                a.this.fOw.user_info.is_block = 1;
                                a.this.fOx.AU(a.this.fOw.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.fOw.user_info.getNameShow()));
                }
            } else if (view == this.fOs) {
                if (this.fOw != null && this.fOw.user_info != null) {
                    if (bzB()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0520a() { // from class: com.baidu.tieba.ala.liveroom.o.a.3
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0520a
                            public void onConfirm() {
                                if (a.this.fOw != null && a.this.fOw.user_info != null) {
                                    a.this.fOw.user_info.is_block = 0;
                                    a.this.fOx.AX(a.this.fOw.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fOw.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0520a() { // from class: com.baidu.tieba.ala.liveroom.o.a.4
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0520a
                        public void onConfirm() {
                            if (a.this.fOw != null && a.this.fOw.user_info != null) {
                                a.this.fOw.user_info.is_block = 2;
                                a.this.fOx.AV(a.this.fOw.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.fOw.user_info.getNameShow()));
                }
            } else if (view == this.fOt) {
                if (this.fOw != null && this.fOw.login_user_info != null) {
                    if (bzD()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0520a() { // from class: com.baidu.tieba.ala.liveroom.o.a.5
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0520a
                            public void onConfirm() {
                                if (a.this.fOw != null && a.this.fOw.login_user_info != null) {
                                    a.this.fOw.login_user_info.is_live_admin = 1;
                                    a.this.fOx.AY(a.this.fOw.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.fOw.user_info.getNameShow()));
                    } else if (bzE()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0520a() { // from class: com.baidu.tieba.ala.liveroom.o.a.6
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0520a
                            public void onConfirm() {
                                if (a.this.fOw != null && a.this.fOw.login_user_info != null) {
                                    a.this.fOw.login_user_info.is_live_admin = 0;
                                    a.this.fOx.AZ(a.this.fOw.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.fOw.user_info.getNameShow()));
                    } else if (bzF()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0520a() { // from class: com.baidu.tieba.ala.liveroom.o.a.7
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0520a
                            public void onConfirm() {
                                if (a.this.fOw != null && a.this.fOw.login_user_info != null) {
                                    a.this.fOw.login_user_info.is_live_admin = 0;
                                    a.this.fOx.bzI();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.cWS) {
                this.fOx.onCancel();
            }
        }
    }

    private void a(final InterfaceC0520a interfaceC0520a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0520a != null) {
                    interfaceC0520a.onConfirm();
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
        this.fOw = personUserData;
        this.aMw = z;
        this.aMx = str;
        if (bzG() || bzH()) {
            qV(8);
            qW(8);
        } else if (bzB()) {
            qV(8);
            this.fOs.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bzC()) {
            qV(0);
            this.fOr.setText(a.i.ala_person_relieve_forbidden_this);
            this.fOs.setText(a.i.ala_person_forbid_forever);
        } else {
            qV(0);
            this.fOr.setText(a.i.ala_person_forbid_this);
            this.fOs.setText(a.i.ala_person_forbid_forever);
        }
        if (bzA()) {
            this.fOt.setVisibility(8);
            this.fOv.setVisibility(8);
        } else if (bzE()) {
            this.fOt.setText(a.i.ala_person_fire_admin);
        } else if (bzD()) {
            this.fOt.setText(a.i.ala_person_appoint_admin);
        } else if (bzG() && bzF()) {
            this.fOt.setText(a.i.ala_person_resign_admin);
        } else {
            this.fOt.setVisibility(8);
            this.fOv.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.fOx = bVar;
    }

    private boolean bzA() {
        return (this.fOw == null || this.fOw.user_info == null || this.fOw.user_info.is_block <= 0) ? false : true;
    }

    private boolean bzB() {
        return (this.fOw == null || this.fOw.user_info == null || this.fOw.user_info.is_block != 2) ? false : true;
    }

    private boolean bzC() {
        return (this.fOw == null || this.fOw.user_info == null || this.fOw.user_info.is_block != 1) ? false : true;
    }

    private boolean bzD() {
        return this.fOw != null && this.fOw.user_info != null && this.aMw && this.fOw.user_info.is_live_admin == 0;
    }

    private boolean bzE() {
        return this.fOw != null && this.fOw.user_info != null && this.aMw && this.fOw.user_info.is_live_admin == 1;
    }

    private boolean bzF() {
        return (this.fOw == null || this.fOw.login_user_info == null || this.aMw || this.fOw.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bzG() {
        return (this.fOw == null || this.fOw.user_info == null || TextUtils.isEmpty(this.aMx) || !this.aMx.equals(this.fOw.user_info.user_id)) ? false : true;
    }

    private boolean bzH() {
        return (this.fOw == null || this.fOw.user_info == null || this.fOw.user_info.is_live_admin != 1) ? false : true;
    }

    private void qV(int i) {
        this.fOr.setVisibility(i);
        this.fOu.setVisibility(i);
    }

    private void qW(int i) {
        this.fOs.setVisibility(i);
        this.fOv.setVisibility(i);
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
