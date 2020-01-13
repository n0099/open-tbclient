package com.baidu.tieba.ala.liveroom.q;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {
    private String apA;
    private boolean apz;
    private TextView ffS;
    private TextView ffT;
    private TextView ffU;
    private View ffV;
    private View ffW;
    private PersonUserData ffX;
    private b ffY;
    private TextView mCancel;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0455a {
        void onConfirm();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bou();

        void onCancel();

        void yR(String str);

        void yS(String str);

        void yT(String str);

        void yU(String str);

        void yV(String str);

        void yW(String str);
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
        this.ffS = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.ffV = findViewById(a.g.ala_person_forbid_this_divider);
        this.ffT = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.ffW = findViewById(a.g.ala_person_forbid_this_divider);
        this.ffU = (TextView) findViewById(a.g.ala_person_admin);
        this.mCancel = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.ffS.setOnClickListener(this);
        this.ffT.setOnClickListener(this);
        this.ffU.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.ffY != null) {
            if (view == this.ffS) {
                if (this.ffX != null && this.ffX.user_info != null) {
                    if (boo()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.q.a.1
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0455a
                            public void onConfirm() {
                                if (a.this.ffX != null && a.this.ffX.user_info != null) {
                                    a.this.ffX.user_info.is_block = 0;
                                    a.this.ffY.yT(a.this.ffX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.ffX.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0455a
                        public void onConfirm() {
                            if (a.this.ffX != null && a.this.ffX.user_info != null) {
                                a.this.ffX.user_info.is_block = 1;
                                a.this.ffY.yR(a.this.ffX.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.ffX.user_info.getNameShow()));
                }
            } else if (view == this.ffT) {
                if (this.ffX != null && this.ffX.user_info != null) {
                    if (bon()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.q.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0455a
                            public void onConfirm() {
                                if (a.this.ffX != null && a.this.ffX.user_info != null) {
                                    a.this.ffX.user_info.is_block = 0;
                                    a.this.ffY.yU(a.this.ffX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.ffX.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.q.a.4
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0455a
                        public void onConfirm() {
                            if (a.this.ffX != null && a.this.ffX.user_info != null) {
                                a.this.ffX.user_info.is_block = 2;
                                a.this.ffY.yS(a.this.ffX.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.ffX.user_info.getNameShow()));
                }
            } else if (view == this.ffU) {
                if (this.ffX != null && this.ffX.login_user_info != null) {
                    if (bop()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.q.a.5
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0455a
                            public void onConfirm() {
                                if (a.this.ffX != null && a.this.ffX.login_user_info != null) {
                                    a.this.ffX.login_user_info.is_live_admin = 1;
                                    a.this.ffY.yV(a.this.ffX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.ffX.user_info.getNameShow()));
                    } else if (boq()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.q.a.6
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0455a
                            public void onConfirm() {
                                if (a.this.ffX != null && a.this.ffX.login_user_info != null) {
                                    a.this.ffX.login_user_info.is_live_admin = 0;
                                    a.this.ffY.yW(a.this.ffX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.ffX.user_info.getNameShow()));
                    } else if (bor()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.q.a.7
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0455a
                            public void onConfirm() {
                                if (a.this.ffX != null && a.this.ffX.login_user_info != null) {
                                    a.this.ffX.login_user_info.is_live_admin = 0;
                                    a.this.ffY.bou();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.mCancel) {
                this.ffY.onCancel();
            }
        }
    }

    private void a(final InterfaceC0455a interfaceC0455a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0455a != null) {
                    interfaceC0455a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.9
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
        this.ffX = personUserData;
        this.apz = z;
        this.apA = str;
        if (bos() || bot()) {
            qt(8);
            qu(8);
        } else if (bon()) {
            qt(8);
            this.ffT.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (boo()) {
            qt(0);
            this.ffS.setText(a.i.ala_person_relieve_forbidden_this);
            this.ffT.setText(a.i.ala_person_forbid_forever);
        } else {
            qt(0);
            this.ffS.setText(a.i.ala_person_forbid_this);
            this.ffT.setText(a.i.ala_person_forbid_forever);
        }
        if (bom()) {
            this.ffU.setVisibility(8);
            this.ffW.setVisibility(8);
        } else if (boq()) {
            this.ffU.setText(a.i.ala_person_fire_admin);
        } else if (bop()) {
            this.ffU.setText(a.i.ala_person_appoint_admin);
        } else if (bos() && bor()) {
            this.ffU.setText(a.i.ala_person_resign_admin);
        } else {
            this.ffU.setVisibility(8);
            this.ffW.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.ffY = bVar;
    }

    private boolean bom() {
        return (this.ffX == null || this.ffX.user_info == null || this.ffX.user_info.is_block <= 0) ? false : true;
    }

    private boolean bon() {
        return (this.ffX == null || this.ffX.user_info == null || this.ffX.user_info.is_block != 2) ? false : true;
    }

    private boolean boo() {
        return (this.ffX == null || this.ffX.user_info == null || this.ffX.user_info.is_block != 1) ? false : true;
    }

    private boolean bop() {
        return this.ffX != null && this.ffX.user_info != null && this.apz && this.ffX.user_info.is_live_admin == 0;
    }

    private boolean boq() {
        return this.ffX != null && this.ffX.user_info != null && this.apz && this.ffX.user_info.is_live_admin == 1;
    }

    private boolean bor() {
        return (this.ffX == null || this.ffX.login_user_info == null || this.apz || this.ffX.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bos() {
        return (this.ffX == null || this.ffX.user_info == null || TextUtils.isEmpty(this.apA) || !this.apA.equals(this.ffX.user_info.user_id)) ? false : true;
    }

    private boolean bot() {
        return (this.ffX == null || this.ffX.user_info == null || this.ffX.user_info.is_live_admin != 1) ? false : true;
    }

    private void qt(int i) {
        this.ffS.setVisibility(i);
        this.ffV.setVisibility(i);
    }

    private void qu(int i) {
        this.ffT.setVisibility(i);
        this.ffW.setVisibility(i);
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
