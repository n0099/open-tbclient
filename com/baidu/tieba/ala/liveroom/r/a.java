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
    private TextView hBb;
    private TextView hBc;
    private TextView hBd;
    private View hBe;
    private View hBf;
    private PersonUserData hBg;
    private b hBh;
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

        void ckl();

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
        this.hBb = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hBe = findViewById(a.f.ala_person_forbid_this_divider);
        this.hBc = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hBf = findViewById(a.f.ala_person_forbid_this_divider);
        this.hBd = (TextView) findViewById(a.f.ala_person_admin);
        this.bTh = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hBb.setOnClickListener(this);
        this.hBc.setOnClickListener(this);
        this.hBd.setOnClickListener(this);
        this.bTh.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hBh != null) {
            if (view == this.hBb) {
                if (this.hBg != null && this.hBg.user_info != null) {
                    if (ckf()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.1
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                    a.this.hBg.user_info.is_block = 0;
                                    a.this.hBh.II(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hBg.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.2
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                        public void onConfirm() {
                            if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                a.this.hBg.user_info.is_block = 1;
                                a.this.hBh.IG(a.this.hBg.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_this_confirm_tip), this.hBg.user_info.getNameShow()));
                }
            } else if (view == this.hBc) {
                if (this.hBg != null && this.hBg.user_info != null) {
                    if (cke()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.3
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                    a.this.hBg.user_info.is_block = 0;
                                    a.this.hBh.IJ(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hBg.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.4
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                        public void onConfirm() {
                            if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                a.this.hBg.user_info.is_block = 2;
                                a.this.hBh.IH(a.this.hBg.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_forever_confirm_tip), this.hBg.user_info.getNameShow()));
                }
            } else if (view == this.hBd) {
                if (this.hBg != null && this.hBg.login_user_info != null) {
                    if (ckg()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.5
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.login_user_info != null) {
                                    a.this.hBg.login_user_info.is_live_admin = 1;
                                    a.this.hBh.IK(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_appoint_admin_confirm_tip), this.hBg.user_info.getNameShow()));
                    } else if (ckh()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.6
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.login_user_info != null) {
                                    a.this.hBg.login_user_info.is_live_admin = 0;
                                    a.this.hBh.IL(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_fire_admin_confirm_tip), this.hBg.user_info.getNameShow()));
                    } else if (cki()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0696a() { // from class: com.baidu.tieba.ala.liveroom.r.a.7
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0696a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.login_user_info != null) {
                                    a.this.hBg.login_user_info.is_live_admin = 0;
                                    a.this.hBh.ckl();
                                }
                            }
                        }, getContext().getResources().getString(a.h.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bTh) {
                this.hBh.onCancel();
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
        this.hBg = personUserData;
        this.bns = z;
        this.aGk = str;
        if (ckj() || ckk()) {
            xm(8);
            xn(8);
        } else if (cke()) {
            xm(8);
            this.hBc.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckf()) {
            xm(0);
            this.hBb.setText(a.h.ala_person_relieve_forbidden_this);
            this.hBc.setText(a.h.ala_person_forbid_forever);
        } else {
            xm(0);
            this.hBb.setText(a.h.ala_person_forbid_this);
            this.hBc.setText(a.h.ala_person_forbid_forever);
        }
        if (ckd()) {
            this.hBd.setVisibility(8);
            this.hBf.setVisibility(8);
        } else if (ckh()) {
            this.hBd.setText(a.h.ala_person_fire_admin);
        } else if (ckg()) {
            this.hBd.setText(a.h.ala_person_appoint_admin);
        } else if (ckj() && cki()) {
            this.hBd.setText(a.h.ala_person_resign_admin);
        } else {
            this.hBd.setVisibility(8);
            this.hBf.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hBh = bVar;
    }

    private boolean ckd() {
        return (this.hBg == null || this.hBg.user_info == null || this.hBg.user_info.is_block <= 0) ? false : true;
    }

    private boolean cke() {
        return (this.hBg == null || this.hBg.user_info == null || this.hBg.user_info.is_block != 2) ? false : true;
    }

    private boolean ckf() {
        return (this.hBg == null || this.hBg.user_info == null || this.hBg.user_info.is_block != 1) ? false : true;
    }

    private boolean ckg() {
        return this.hBg != null && this.hBg.user_info != null && this.bns && this.hBg.user_info.is_live_admin == 0;
    }

    private boolean ckh() {
        return this.hBg != null && this.hBg.user_info != null && this.bns && this.hBg.user_info.is_live_admin == 1;
    }

    private boolean cki() {
        return (this.hBg == null || this.hBg.login_user_info == null || this.bns || this.hBg.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean ckj() {
        return (this.hBg == null || this.hBg.user_info == null || TextUtils.isEmpty(this.aGk) || !this.aGk.equals(this.hBg.user_info.user_id)) ? false : true;
    }

    private boolean ckk() {
        return (this.hBg == null || this.hBg.user_info == null || this.hBg.user_info.is_live_admin != 1) ? false : true;
    }

    private void xm(int i) {
        this.hBb.setVisibility(i);
        this.hBe.setVisibility(i);
    }

    private void xn(int i) {
        this.hBc.setVisibility(i);
        this.hBf.setVisibility(i);
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
