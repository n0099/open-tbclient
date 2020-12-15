package com.baidu.tieba.ala.liveroom.r;

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
    private String aGk;
    private TextView bTh;
    private boolean bns;
    private TextView hBd;
    private TextView hBe;
    private TextView hBf;
    private View hBg;
    private View hBh;
    private PersonUserData hBi;
    private b hBj;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0696a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void IG(String str);

        void IH(String str);

        void II(String str);

        void IJ(String str);

        void IK(String str);

        void IL(String str);

        void ckm();

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
        this.hBd = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hBg = findViewById(a.f.ala_person_forbid_this_divider);
        this.hBe = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hBh = findViewById(a.f.ala_person_forbid_this_divider);
        this.hBf = (TextView) findViewById(a.f.ala_person_admin);
        this.bTh = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hBd.setOnClickListener(this);
        this.hBe.setOnClickListener(this);
        this.hBf.setOnClickListener(this);
        this.bTh.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hBj != null) {
            if (view == this.hBd) {
                if (this.hBi != null && this.hBi.user_info != null) {
                    if (ckg()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.1
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                    a.this.hBi.user_info.is_block = 0;
                                    a.this.hBj.II(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hBi.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.2
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                        public void onConfirm() {
                            if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                a.this.hBi.user_info.is_block = 1;
                                a.this.hBj.IG(a.this.hBi.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_this_confirm_tip), this.hBi.user_info.getNameShow()));
                }
            } else if (view == this.hBe) {
                if (this.hBi != null && this.hBi.user_info != null) {
                    if (ckf()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.3
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                    a.this.hBi.user_info.is_block = 0;
                                    a.this.hBj.IJ(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hBi.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.4
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                        public void onConfirm() {
                            if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                a.this.hBi.user_info.is_block = 2;
                                a.this.hBj.IH(a.this.hBi.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_forever_confirm_tip), this.hBi.user_info.getNameShow()));
                }
            } else if (view == this.hBf) {
                if (this.hBi != null && this.hBi.login_user_info != null) {
                    if (ckh()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.5
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.login_user_info != null) {
                                    a.this.hBi.login_user_info.is_live_admin = 1;
                                    a.this.hBj.IK(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_appoint_admin_confirm_tip), this.hBi.user_info.getNameShow()));
                    } else if (cki()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.6
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.login_user_info != null) {
                                    a.this.hBi.login_user_info.is_live_admin = 0;
                                    a.this.hBj.IL(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_fire_admin_confirm_tip), this.hBi.user_info.getNameShow()));
                    } else if (ckj()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.7
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.login_user_info != null) {
                                    a.this.hBi.login_user_info.is_live_admin = 0;
                                    a.this.hBj.ckm();
                                }
                            }
                        }, getContext().getResources().getString(a.h.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bTh) {
                this.hBj.onCancel();
            }
        }
    }

    private void a(final InterfaceC0696a interfaceC0696a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0696a != null) {
                    interfaceC0696a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.a.9
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
        this.hBi = personUserData;
        this.bns = z;
        this.aGk = str;
        if (ckk() || ckl()) {
            xm(8);
            xn(8);
        } else if (ckf()) {
            xm(8);
            this.hBe.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckg()) {
            xm(0);
            this.hBd.setText(a.h.ala_person_relieve_forbidden_this);
            this.hBe.setText(a.h.ala_person_forbid_forever);
        } else {
            xm(0);
            this.hBd.setText(a.h.ala_person_forbid_this);
            this.hBe.setText(a.h.ala_person_forbid_forever);
        }
        if (cke()) {
            this.hBf.setVisibility(8);
            this.hBh.setVisibility(8);
        } else if (cki()) {
            this.hBf.setText(a.h.ala_person_fire_admin);
        } else if (ckh()) {
            this.hBf.setText(a.h.ala_person_appoint_admin);
        } else if (ckk() && ckj()) {
            this.hBf.setText(a.h.ala_person_resign_admin);
        } else {
            this.hBf.setVisibility(8);
            this.hBh.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hBj = bVar;
    }

    private boolean cke() {
        return (this.hBi == null || this.hBi.user_info == null || this.hBi.user_info.is_block <= 0) ? false : true;
    }

    private boolean ckf() {
        return (this.hBi == null || this.hBi.user_info == null || this.hBi.user_info.is_block != 2) ? false : true;
    }

    private boolean ckg() {
        return (this.hBi == null || this.hBi.user_info == null || this.hBi.user_info.is_block != 1) ? false : true;
    }

    private boolean ckh() {
        return this.hBi != null && this.hBi.user_info != null && this.bns && this.hBi.user_info.is_live_admin == 0;
    }

    private boolean cki() {
        return this.hBi != null && this.hBi.user_info != null && this.bns && this.hBi.user_info.is_live_admin == 1;
    }

    private boolean ckj() {
        return (this.hBi == null || this.hBi.login_user_info == null || this.bns || this.hBi.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean ckk() {
        return (this.hBi == null || this.hBi.user_info == null || TextUtils.isEmpty(this.aGk) || !this.aGk.equals(this.hBi.user_info.user_id)) ? false : true;
    }

    private boolean ckl() {
        return (this.hBi == null || this.hBi.user_info == null || this.hBi.user_info.is_live_admin != 1) ? false : true;
    }

    private void xm(int i) {
        this.hBd.setVisibility(i);
        this.hBg.setVisibility(i);
    }

    private void xn(int i) {
        this.hBe.setVisibility(i);
        this.hBh.setVisibility(i);
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
