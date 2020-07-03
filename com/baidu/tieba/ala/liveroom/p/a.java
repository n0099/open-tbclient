package com.baidu.tieba.ala.liveroom.p;

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
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private boolean aVc;
    private String aVd;
    private TextView dmF;
    private TextView gpB;
    private TextView gpC;
    private TextView gpD;
    private View gpE;
    private View gpF;
    private PersonUserData gpG;
    private b gpH;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0577a {
        void onConfirm();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Dd(String str);

        void De(String str);

        void Df(String str);

        void Dg(String str);

        void Dh(String str);

        void Di(String str);

        void bIY();

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
        this.gpB = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.gpE = findViewById(a.g.ala_person_forbid_this_divider);
        this.gpC = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.gpF = findViewById(a.g.ala_person_forbid_this_divider);
        this.gpD = (TextView) findViewById(a.g.ala_person_admin);
        this.dmF = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.gpB.setOnClickListener(this);
        this.gpC.setOnClickListener(this);
        this.gpD.setOnClickListener(this);
        this.dmF.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.gpH != null) {
            if (view == this.gpB) {
                if (this.gpG != null && this.gpG.user_info != null) {
                    if (bIS()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0577a() { // from class: com.baidu.tieba.ala.liveroom.p.a.1
                            @Override // com.baidu.tieba.ala.liveroom.p.a.InterfaceC0577a
                            public void onConfirm() {
                                if (a.this.gpG != null && a.this.gpG.user_info != null) {
                                    a.this.gpG.user_info.is_block = 0;
                                    a.this.gpH.Df(a.this.gpG.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gpG.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0577a() { // from class: com.baidu.tieba.ala.liveroom.p.a.2
                        @Override // com.baidu.tieba.ala.liveroom.p.a.InterfaceC0577a
                        public void onConfirm() {
                            if (a.this.gpG != null && a.this.gpG.user_info != null) {
                                a.this.gpG.user_info.is_block = 1;
                                a.this.gpH.Dd(a.this.gpG.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.gpG.user_info.getNameShow()));
                }
            } else if (view == this.gpC) {
                if (this.gpG != null && this.gpG.user_info != null) {
                    if (bIR()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0577a() { // from class: com.baidu.tieba.ala.liveroom.p.a.3
                            @Override // com.baidu.tieba.ala.liveroom.p.a.InterfaceC0577a
                            public void onConfirm() {
                                if (a.this.gpG != null && a.this.gpG.user_info != null) {
                                    a.this.gpG.user_info.is_block = 0;
                                    a.this.gpH.Dg(a.this.gpG.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gpG.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0577a() { // from class: com.baidu.tieba.ala.liveroom.p.a.4
                        @Override // com.baidu.tieba.ala.liveroom.p.a.InterfaceC0577a
                        public void onConfirm() {
                            if (a.this.gpG != null && a.this.gpG.user_info != null) {
                                a.this.gpG.user_info.is_block = 2;
                                a.this.gpH.De(a.this.gpG.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.gpG.user_info.getNameShow()));
                }
            } else if (view == this.gpD) {
                if (this.gpG != null && this.gpG.login_user_info != null) {
                    if (bIT()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0577a() { // from class: com.baidu.tieba.ala.liveroom.p.a.5
                            @Override // com.baidu.tieba.ala.liveroom.p.a.InterfaceC0577a
                            public void onConfirm() {
                                if (a.this.gpG != null && a.this.gpG.login_user_info != null) {
                                    a.this.gpG.login_user_info.is_live_admin = 1;
                                    a.this.gpH.Dh(a.this.gpG.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.gpG.user_info.getNameShow()));
                    } else if (bIU()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0577a() { // from class: com.baidu.tieba.ala.liveroom.p.a.6
                            @Override // com.baidu.tieba.ala.liveroom.p.a.InterfaceC0577a
                            public void onConfirm() {
                                if (a.this.gpG != null && a.this.gpG.login_user_info != null) {
                                    a.this.gpG.login_user_info.is_live_admin = 0;
                                    a.this.gpH.Di(a.this.gpG.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.gpG.user_info.getNameShow()));
                    } else if (bIV()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0577a() { // from class: com.baidu.tieba.ala.liveroom.p.a.7
                            @Override // com.baidu.tieba.ala.liveroom.p.a.InterfaceC0577a
                            public void onConfirm() {
                                if (a.this.gpG != null && a.this.gpG.login_user_info != null) {
                                    a.this.gpG.login_user_info.is_live_admin = 0;
                                    a.this.gpH.bIY();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.dmF) {
                this.gpH.onCancel();
            }
        }
    }

    private void a(final InterfaceC0577a interfaceC0577a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0577a != null) {
                    interfaceC0577a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.9
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
        this.gpG = personUserData;
        this.aVc = z;
        this.aVd = str;
        if (bIW() || bIX()) {
            rW(8);
            rX(8);
        } else if (bIR()) {
            rW(8);
            this.gpC.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bIS()) {
            rW(0);
            this.gpB.setText(a.i.ala_person_relieve_forbidden_this);
            this.gpC.setText(a.i.ala_person_forbid_forever);
        } else {
            rW(0);
            this.gpB.setText(a.i.ala_person_forbid_this);
            this.gpC.setText(a.i.ala_person_forbid_forever);
        }
        if (bIQ()) {
            this.gpD.setVisibility(8);
            this.gpF.setVisibility(8);
        } else if (bIU()) {
            this.gpD.setText(a.i.ala_person_fire_admin);
        } else if (bIT()) {
            this.gpD.setText(a.i.ala_person_appoint_admin);
        } else if (bIW() && bIV()) {
            this.gpD.setText(a.i.ala_person_resign_admin);
        } else {
            this.gpD.setVisibility(8);
            this.gpF.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.gpH = bVar;
    }

    private boolean bIQ() {
        return (this.gpG == null || this.gpG.user_info == null || this.gpG.user_info.is_block <= 0) ? false : true;
    }

    private boolean bIR() {
        return (this.gpG == null || this.gpG.user_info == null || this.gpG.user_info.is_block != 2) ? false : true;
    }

    private boolean bIS() {
        return (this.gpG == null || this.gpG.user_info == null || this.gpG.user_info.is_block != 1) ? false : true;
    }

    private boolean bIT() {
        return this.gpG != null && this.gpG.user_info != null && this.aVc && this.gpG.user_info.is_live_admin == 0;
    }

    private boolean bIU() {
        return this.gpG != null && this.gpG.user_info != null && this.aVc && this.gpG.user_info.is_live_admin == 1;
    }

    private boolean bIV() {
        return (this.gpG == null || this.gpG.login_user_info == null || this.aVc || this.gpG.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bIW() {
        return (this.gpG == null || this.gpG.user_info == null || TextUtils.isEmpty(this.aVd) || !this.aVd.equals(this.gpG.user_info.user_id)) ? false : true;
    }

    private boolean bIX() {
        return (this.gpG == null || this.gpG.user_info == null || this.gpG.user_info.is_live_admin != 1) ? false : true;
    }

    private void rW(int i) {
        this.gpB.setVisibility(i);
        this.gpE.setVisibility(i);
    }

    private void rX(int i) {
        this.gpC.setVisibility(i);
        this.gpF.setVisibility(i);
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
