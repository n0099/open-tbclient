package com.baidu.tieba.ala.live.pkpanel.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private TextView gRX;
    private RecyclerView gRY;
    private JSONObject gRZ;
    private com.baidu.tieba.ala.live.pkpanel.b.a gSa;
    private Context mContext;
    private Dialog mDialog;
    private int mOrientation;
    private View mRootView;
    private TextView title;

    public a(Context context, int i, JSONObject jSONObject) {
        this.mContext = context;
        this.gRZ = jSONObject;
        this.mOrientation = i;
        parseData(this.gRZ);
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_rule, (ViewGroup) null);
        this.title = (TextView) this.mRootView.findViewById(a.f.ala_title);
        this.gRX = (TextView) this.mRootView.findViewById(a.f.ala_close);
        this.gRX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.pkpanel.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hide();
            }
        });
        this.gRY = (RecyclerView) this.mRootView.findViewById(a.f.giftRecycle);
        this.gRY.setLayoutManager(new LinearLayoutManager(this.mContext));
        b bVar = new b(this.mContext);
        if (this.gSa != null) {
            this.title.setText(this.gSa.mTitle);
            bVar.setData(this.gSa.gxS);
        }
        this.gRY.setAdapter(bVar);
    }

    public void Qj() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.RuleDialog);
            this.mDialog.setContentView(this.mRootView);
        }
        va(this.mOrientation);
        if (!isShowing()) {
            this.mDialog.show();
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (this.gSa == null) {
            this.gSa = new com.baidu.tieba.ala.live.pkpanel.b.a();
        }
        this.gSa.parseData(jSONObject);
    }

    private void va(int i) {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            if (i == 1) {
                attributes.height = -2;
                attributes.width = -2;
            } else {
                attributes.width = -2;
                attributes.height = c(274.0f, this.mDialog.getContext());
            }
            window.setAttributes(attributes);
        }
    }

    private int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public boolean isShowing() {
        return this.mDialog != null && this.mDialog.isShowing();
    }

    public void hide() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public void vb(int i) {
        this.mOrientation = i;
        if (isShowing()) {
            hide();
            Qj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<com.baidu.tieba.ala.live.pkpanel.b.b> gxS;
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public void setData(List<com.baidu.tieba.ala.live.pkpanel.b.b> list) {
            this.gxS = list;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                    return new c(LayoutInflater.from(this.mContext).inflate(a.g.ala_rule_content_item, viewGroup, false));
                case 2:
                    return new C0664a(LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_foot_rule, viewGroup, false));
                default:
                    return null;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (this.gxS != null) {
                if ((viewHolder instanceof c) && this.gxS.size() > 0) {
                    com.baidu.tieba.ala.live.pkpanel.b.b bVar = this.gxS.get(i);
                    if (bVar != null) {
                        ((c) viewHolder).a(bVar, i);
                    }
                } else if (viewHolder instanceof C0664a) {
                    ((C0664a) viewHolder).a(a.this.gSa);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.gSa == null || a.this.gSa.gxS == null) {
                return 0;
            }
            return a.this.gSa.gxS.size() + 1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return vc(i) ? 2 : 1;
        }

        private boolean vc(int i) {
            return (a.this.gSa == null || a.this.gSa.gxS == null || a.this.gSa.gxS.size() != i) ? false : true;
        }
    }

    /* loaded from: classes4.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView ebD;
        private TextView gSc;
        private HeadImageView gSd;
        private TextView gSe;
        private com.baidu.tieba.ala.live.pkpanel.b.b gSf;

        public c(@NonNull View view) {
            super(view);
            this.gSd = (HeadImageView) view.findViewById(a.f.gift_icon);
            this.ebD = (TextView) view.findViewById(a.f.gift_name);
            this.gSe = (TextView) view.findViewById(a.f.gift_type);
            this.gSc = (TextView) view.findViewById(a.f.gift_describe);
            if (this.gSd != null) {
                this.gSd.setIsRound(true);
                this.gSd.setAutoChangeStyle(false);
                this.gSd.setDefaultResource(a.e.sdk_default_avatar);
            }
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.b bVar, int i) {
            this.gSf = bVar;
            if (this.gSf != null && i < a.this.gSa.gxS.size()) {
                if (TextUtils.isEmpty(this.gSf.icon)) {
                    this.gSd.setDefaultResource(a.e.sdk_default_avatar);
                } else {
                    this.gSd.setUrl(this.gSf.icon);
                    l.a(this.gSd, this.gSf.icon, false, false);
                }
                this.ebD.setText(this.gSf.name);
                this.gSe.setText(this.gSf.type);
                this.gSe.setTextColor(Color.parseColor(this.gSf.gSh));
                this.gSc.setText(this.gSf.content);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0664a extends RecyclerView.ViewHolder {
        TextView gSc;
        TextView title;

        public C0664a(@NonNull View view) {
            super(view);
            this.title = (TextView) view.findViewById(a.f.ala_title);
            this.gSc = (TextView) view.findViewById(a.f.ala_content);
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.a aVar) {
            if (aVar != null) {
                this.title.setText(aVar.activityName);
                this.gSc.setText(aVar.gSg);
            }
        }
    }
}
