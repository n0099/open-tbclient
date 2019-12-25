package com.baidu.tieba.ala.liveroom.n;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {
    private boolean aoM;
    private String aoN;
    private TextView fcM;
    private TextView fcN;
    private TextView fcO;
    private View fcP;
    private View fcQ;
    private PersonUserData fcR;
    private b fcS;
    private TextView mCancel;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0450a {
        void onConfirm();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bnu();

        void onCancel();

        void yI(String str);

        void yJ(String str);

        void yK(String str);

        void yL(String str);

        void yM(String str);

        void yN(String str);
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
        this.fcM = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.fcP = findViewById(a.g.ala_person_forbid_this_divider);
        this.fcN = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.fcQ = findViewById(a.g.ala_person_forbid_this_divider);
        this.fcO = (TextView) findViewById(a.g.ala_person_admin);
        this.mCancel = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.fcM.setOnClickListener(this);
        this.fcN.setOnClickListener(this);
        this.fcO.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.fcS != null) {
            if (view == this.fcM) {
                if (this.fcR != null && this.fcR.user_info != null) {
                    if (bno()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0450a() { // from class: com.baidu.tieba.ala.liveroom.n.a.1
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0450a
                            public void onConfirm() {
                                if (a.this.fcR != null && a.this.fcR.user_info != null) {
                                    a.this.fcR.user_info.is_block = 0;
                                    a.this.fcS.yK(a.this.fcR.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fcR.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0450a() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
                        @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0450a
                        public void onConfirm() {
                            if (a.this.fcR != null && a.this.fcR.user_info != null) {
                                a.this.fcR.user_info.is_block = 1;
                                a.this.fcS.yI(a.this.fcR.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.fcR.user_info.getNameShow()));
                }
            } else if (view == this.fcN) {
                if (this.fcR != null && this.fcR.user_info != null) {
                    if (bnn()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0450a() { // from class: com.baidu.tieba.ala.liveroom.n.a.3
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0450a
                            public void onConfirm() {
                                if (a.this.fcR != null && a.this.fcR.user_info != null) {
                                    a.this.fcR.user_info.is_block = 0;
                                    a.this.fcS.yL(a.this.fcR.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fcR.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0450a() { // from class: com.baidu.tieba.ala.liveroom.n.a.4
                        @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0450a
                        public void onConfirm() {
                            if (a.this.fcR != null && a.this.fcR.user_info != null) {
                                a.this.fcR.user_info.is_block = 2;
                                a.this.fcS.yJ(a.this.fcR.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.fcR.user_info.getNameShow()));
                }
            } else if (view == this.fcO) {
                if (this.fcR != null && this.fcR.login_user_info != null) {
                    if (bnp()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0450a() { // from class: com.baidu.tieba.ala.liveroom.n.a.5
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0450a
                            public void onConfirm() {
                                if (a.this.fcR != null && a.this.fcR.login_user_info != null) {
                                    a.this.fcR.login_user_info.is_live_admin = 1;
                                    a.this.fcS.yM(a.this.fcR.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.fcR.user_info.getNameShow()));
                    } else if (bnq()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0450a() { // from class: com.baidu.tieba.ala.liveroom.n.a.6
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0450a
                            public void onConfirm() {
                                if (a.this.fcR != null && a.this.fcR.login_user_info != null) {
                                    a.this.fcR.login_user_info.is_live_admin = 0;
                                    a.this.fcS.yN(a.this.fcR.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.fcR.user_info.getNameShow()));
                    } else if (bnr()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0450a() { // from class: com.baidu.tieba.ala.liveroom.n.a.7
                            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0450a
                            public void onConfirm() {
                                if (a.this.fcR != null && a.this.fcR.login_user_info != null) {
                                    a.this.fcR.login_user_info.is_live_admin = 0;
                                    a.this.fcS.bnu();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.mCancel) {
                this.fcS.onCancel();
            }
        }
    }

    private void a(final InterfaceC0450a interfaceC0450a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0450a != null) {
                    interfaceC0450a.onConfirm();
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
        this.fcR = personUserData;
        this.aoM = z;
        this.aoN = str;
        if (bns() || bnt()) {
            qo(8);
            qp(8);
        } else if (bnn()) {
            qo(8);
            this.fcN.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bno()) {
            qo(0);
            this.fcM.setText(a.i.ala_person_relieve_forbidden_this);
            this.fcN.setText(a.i.ala_person_forbid_forever);
        } else {
            qo(0);
            this.fcM.setText(a.i.ala_person_forbid_this);
            this.fcN.setText(a.i.ala_person_forbid_forever);
        }
        if (bnm()) {
            this.fcO.setVisibility(8);
            this.fcQ.setVisibility(8);
        } else if (bnq()) {
            this.fcO.setText(a.i.ala_person_fire_admin);
        } else if (bnp()) {
            this.fcO.setText(a.i.ala_person_appoint_admin);
        } else if (bns() && bnr()) {
            this.fcO.setText(a.i.ala_person_resign_admin);
        } else {
            this.fcO.setVisibility(8);
            this.fcQ.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.fcS = bVar;
    }

    private boolean bnm() {
        return (this.fcR == null || this.fcR.user_info == null || this.fcR.user_info.is_block <= 0) ? false : true;
    }

    private boolean bnn() {
        return (this.fcR == null || this.fcR.user_info == null || this.fcR.user_info.is_block != 2) ? false : true;
    }

    private boolean bno() {
        return (this.fcR == null || this.fcR.user_info == null || this.fcR.user_info.is_block != 1) ? false : true;
    }

    private boolean bnp() {
        return this.fcR != null && this.fcR.user_info != null && this.aoM && this.fcR.user_info.is_live_admin == 0;
    }

    private boolean bnq() {
        return this.fcR != null && this.fcR.user_info != null && this.aoM && this.fcR.user_info.is_live_admin == 1;
    }

    private boolean bnr() {
        return (this.fcR == null || this.fcR.login_user_info == null || this.aoM || this.fcR.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bns() {
        return (this.fcR == null || this.fcR.user_info == null || TextUtils.isEmpty(this.aoN) || !this.aoN.equals(this.fcR.user_info.user_id)) ? false : true;
    }

    private boolean bnt() {
        return (this.fcR == null || this.fcR.user_info == null || this.fcR.user_info.is_live_admin != 1) ? false : true;
    }

    private void qo(int i) {
        this.fcM.setVisibility(i);
        this.fcP.setVisibility(i);
    }

    private void qp(int i) {
        this.fcN.setVisibility(i);
        this.fcQ.setVisibility(i);
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
