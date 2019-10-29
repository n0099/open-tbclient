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
    private boolean ahd;
    private String ahe;
    private TextView bIS;
    private TextView enm;
    private TextView enn;
    private TextView eno;
    private View enp;
    private View enq;
    private PersonUserData enr;
    private b ens;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0366a {
        void onConfirm();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void aVE();

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
        this.enm = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.enp = findViewById(a.g.ala_person_forbid_this_divider);
        this.enn = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.enq = findViewById(a.g.ala_person_forbid_this_divider);
        this.eno = (TextView) findViewById(a.g.ala_person_admin);
        this.bIS = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.enm.setOnClickListener(this);
        this.enn.setOnClickListener(this);
        this.eno.setOnClickListener(this);
        this.bIS.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.ens != null) {
            if (view == this.enm) {
                if (this.enr != null && this.enr.user_info != null) {
                    if (aVy()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0366a() { // from class: com.baidu.tieba.ala.liveroom.n.a.1
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0366a
                            public void onConfirm() {
                                if (a.this.enr != null && a.this.enr.user_info != null) {
                                    a.this.enr.user_info.is_block = 0;
                                    a.this.ens.tW(a.this.enr.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.enr.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0366a() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
                        @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0366a
                        public void onConfirm() {
                            if (a.this.enr != null && a.this.enr.user_info != null) {
                                a.this.enr.user_info.is_block = 1;
                                a.this.ens.tU(a.this.enr.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.enr.user_info.getNameShow()));
                }
            } else if (view == this.enn) {
                if (this.enr != null && this.enr.user_info != null) {
                    if (aVx()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0366a() { // from class: com.baidu.tieba.ala.liveroom.n.a.3
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0366a
                            public void onConfirm() {
                                if (a.this.enr != null && a.this.enr.user_info != null) {
                                    a.this.enr.user_info.is_block = 0;
                                    a.this.ens.tX(a.this.enr.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.enr.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0366a() { // from class: com.baidu.tieba.ala.liveroom.n.a.4
                        @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0366a
                        public void onConfirm() {
                            if (a.this.enr != null && a.this.enr.user_info != null) {
                                a.this.enr.user_info.is_block = 2;
                                a.this.ens.tV(a.this.enr.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.enr.user_info.getNameShow()));
                }
            } else if (view == this.eno) {
                if (this.enr != null && this.enr.login_user_info != null) {
                    if (aVz()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0366a() { // from class: com.baidu.tieba.ala.liveroom.n.a.5
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0366a
                            public void onConfirm() {
                                if (a.this.enr != null && a.this.enr.login_user_info != null) {
                                    a.this.enr.login_user_info.is_live_admin = 1;
                                    a.this.ens.tY(a.this.enr.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.enr.user_info.getNameShow()));
                    } else if (aVA()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0366a() { // from class: com.baidu.tieba.ala.liveroom.n.a.6
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0366a
                            public void onConfirm() {
                                if (a.this.enr != null && a.this.enr.login_user_info != null) {
                                    a.this.enr.login_user_info.is_live_admin = 0;
                                    a.this.ens.tZ(a.this.enr.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.enr.user_info.getNameShow()));
                    } else if (aVB()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0366a() { // from class: com.baidu.tieba.ala.liveroom.n.a.7
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0366a
                            public void onConfirm() {
                                if (a.this.enr != null && a.this.enr.login_user_info != null) {
                                    a.this.enr.login_user_info.is_live_admin = 0;
                                    a.this.ens.aVE();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bIS) {
                this.ens.onCancel();
            }
        }
    }

    private void a(final InterfaceC0366a interfaceC0366a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0366a != null) {
                    interfaceC0366a.onConfirm();
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
        this.enr = personUserData;
        this.ahd = z;
        this.ahe = str;
        if (aVC() || aVD()) {
            nY(8);
            nZ(8);
        } else if (aVx()) {
            nY(8);
            this.enn.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (aVy()) {
            nY(0);
            this.enm.setText(a.i.ala_person_relieve_forbidden_this);
            this.enn.setText(a.i.ala_person_forbid_forever);
        } else {
            nY(0);
            this.enm.setText(a.i.ala_person_forbid_this);
            this.enn.setText(a.i.ala_person_forbid_forever);
        }
        if (aVw()) {
            this.eno.setVisibility(8);
            this.enq.setVisibility(8);
        } else if (aVA()) {
            this.eno.setText(a.i.ala_person_fire_admin);
        } else if (aVz()) {
            this.eno.setText(a.i.ala_person_appoint_admin);
        } else if (aVC() && aVB()) {
            this.eno.setText(a.i.ala_person_resign_admin);
        } else {
            this.eno.setVisibility(8);
            this.enq.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.ens = bVar;
    }

    private boolean aVw() {
        return (this.enr == null || this.enr.user_info == null || this.enr.user_info.is_block <= 0) ? false : true;
    }

    private boolean aVx() {
        return (this.enr == null || this.enr.user_info == null || this.enr.user_info.is_block != 2) ? false : true;
    }

    private boolean aVy() {
        return (this.enr == null || this.enr.user_info == null || this.enr.user_info.is_block != 1) ? false : true;
    }

    private boolean aVz() {
        return this.enr != null && this.enr.user_info != null && this.ahd && this.enr.user_info.is_live_admin == 0;
    }

    private boolean aVA() {
        return this.enr != null && this.enr.user_info != null && this.ahd && this.enr.user_info.is_live_admin == 1;
    }

    private boolean aVB() {
        return (this.enr == null || this.enr.login_user_info == null || this.ahd || this.enr.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean aVC() {
        return (this.enr == null || this.enr.user_info == null || TextUtils.isEmpty(this.ahe) || !this.ahe.equals(this.enr.user_info.user_id)) ? false : true;
    }

    private boolean aVD() {
        return (this.enr == null || this.enr.user_info == null || this.enr.user_info.is_live_admin != 1) ? false : true;
    }

    private void nY(int i) {
        this.enm.setVisibility(i);
        this.enp.setVisibility(i);
    }

    private void nZ(int i) {
        this.enn.setVisibility(i);
        this.enq.setVisibility(i);
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
