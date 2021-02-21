package com.baidu.tieba.ala.live.pkpanel.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private TextView hmA;
    private RecyclerView hmB;
    private JSONObject hmC;
    private com.baidu.tieba.ala.live.pkpanel.b.a hmD;
    private Context mContext;
    private Dialog mDialog;
    private int mOrientation;
    private View mRootView;
    private TextView title;

    public a(Context context, int i, JSONObject jSONObject) {
        this.mContext = context;
        this.hmC = jSONObject;
        this.mOrientation = i;
        parseData(this.hmC);
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_rule, (ViewGroup) null);
        this.title = (TextView) this.mRootView.findViewById(a.f.ala_title);
        this.hmA = (TextView) this.mRootView.findViewById(a.f.ala_close);
        this.hmA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.pkpanel.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hide();
            }
        });
        this.hmB = (RecyclerView) this.mRootView.findViewById(a.f.giftRecycle);
        this.hmB.setLayoutManager(new LinearLayoutManager(this.mContext));
        b bVar = new b(this.mContext);
        if (this.hmD != null) {
            this.title.setText(this.hmD.mTitle);
            bVar.setData(this.hmD.gQp);
        }
        this.hmB.setAdapter(bVar);
    }

    public void QE() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.RuleDialog);
            this.mDialog.setContentView(this.mRootView);
        }
        uU(this.mOrientation);
        if (!isShowing()) {
            this.mDialog.show();
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (this.hmD == null) {
            this.hmD = new com.baidu.tieba.ala.live.pkpanel.b.a();
        }
        this.hmD.parseData(jSONObject);
    }

    private void uU(int i) {
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
                attributes.height = d(274.0f, this.mDialog.getContext());
            }
            window.setAttributes(attributes);
        }
    }

    private int d(float f, Context context) {
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

    public void uV(int i) {
        this.mOrientation = i;
        if (isShowing()) {
            hide();
            QE();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<com.baidu.tieba.ala.live.pkpanel.b.b> gQp;
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public void setData(List<com.baidu.tieba.ala.live.pkpanel.b.b> list) {
            this.gQp = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                    return new c(LayoutInflater.from(this.mContext).inflate(a.g.ala_rule_content_item, viewGroup, false));
                case 2:
                    return new C0653a(LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_foot_rule, viewGroup, false));
                default:
                    return null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (this.gQp != null) {
                if ((viewHolder instanceof c) && this.gQp.size() > 0) {
                    com.baidu.tieba.ala.live.pkpanel.b.b bVar = this.gQp.get(i);
                    if (bVar != null) {
                        ((c) viewHolder).a(bVar, i);
                    }
                } else if (viewHolder instanceof C0653a) {
                    ((C0653a) viewHolder).a(a.this.hmD);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.hmD == null || a.this.hmD.gQp == null) {
                return 0;
            }
            return a.this.hmD.gQp.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return uW(i) ? 2 : 1;
        }

        private boolean uW(int i) {
            return (a.this.hmD == null || a.this.hmD.gQp == null || a.this.hmD.gQp.size() != i) ? false : true;
        }
    }

    /* loaded from: classes11.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView enq;
        private TextView hmF;
        private HeadImageView hmG;
        private TextView hmH;
        private com.baidu.tieba.ala.live.pkpanel.b.b hmI;

        public c(@NonNull View view) {
            super(view);
            this.hmG = (HeadImageView) view.findViewById(a.f.gift_icon);
            this.enq = (TextView) view.findViewById(a.f.gift_name);
            this.hmH = (TextView) view.findViewById(a.f.gift_type);
            this.hmF = (TextView) view.findViewById(a.f.gift_describe);
            if (this.hmG != null) {
                this.hmG.setIsRound(true);
                this.hmG.setAutoChangeStyle(false);
                this.hmG.setDefaultResource(a.e.sdk_default_avatar);
            }
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.b bVar, int i) {
            this.hmI = bVar;
            if (this.hmI != null && i < a.this.hmD.gQp.size()) {
                if (TextUtils.isEmpty(this.hmI.icon)) {
                    this.hmG.setDefaultResource(a.e.sdk_default_avatar);
                } else {
                    this.hmG.setUrl(this.hmI.icon);
                    m.a(this.hmG, this.hmI.icon, false, false);
                }
                this.enq.setText(this.hmI.name);
                this.hmH.setText(this.hmI.type);
                this.hmH.setTextColor(Color.parseColor(this.hmI.hmK));
                this.hmF.setText(this.hmI.content);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0653a extends RecyclerView.ViewHolder {
        TextView hmF;
        TextView title;

        public C0653a(@NonNull View view) {
            super(view);
            this.title = (TextView) view.findViewById(a.f.ala_title);
            this.hmF = (TextView) view.findViewById(a.f.ala_content);
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.a aVar) {
            if (aVar != null) {
                this.title.setText(aVar.activityName);
                this.hmF.setText(aVar.hmJ);
            }
        }
    }
}
