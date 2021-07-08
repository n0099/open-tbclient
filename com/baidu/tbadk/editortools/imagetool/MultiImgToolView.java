package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.a.d;
import d.a.c.e.p.l;
import d.a.o0.w.n;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgToolView extends DragContainer implements n, DragHorizonScrollView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public DragHorizonScrollView f13010i;
    public TextView j;
    public DragLayer k;
    public WriteImagesInfo l;
    public d.a.o0.b0.b m;
    public c n;
    public EditorTools o;
    public int p;
    public String q;
    public int r;
    public int s;
    public boolean t;
    public String u;
    public b v;

    /* loaded from: classes3.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiImgToolView f13011a;

        public a(MultiImgToolView multiImgToolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgToolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13011a = multiImgToolView;
        }

        @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13011a.f13010i.s()) {
                return;
            }
            this.f13011a.c(view);
            int q = this.f13011a.f13010i.q(view);
            if (q < 0 || q >= this.f13011a.l.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.f13011a.l.getChosedFiles().remove(q);
            if (remove.isTempFile()) {
                d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            int maxItemNum = this.f13011a.f13010i.getMaxItemNum();
            int size = this.f13011a.l.size();
            this.f13011a.j.setText(this.f13011a.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            int size2 = this.f13011a.l.getChosedFiles().size();
            if (this.f13011a.o != null) {
                this.f13011a.o.A(new d.a.o0.w.a(this.f13011a.r, -1, null));
                if (size2 > 0) {
                    this.f13011a.o.A(new d.a.o0.w.a(2, this.f13011a.s, String.valueOf(size2)));
                } else {
                    this.f13011a.o.A(new d.a.o0.w.a(2, this.f13011a.s, null));
                }
                if (maxItemNum == 1 && size2 == 0) {
                    if (this.f13011a.t) {
                        this.f13011a.o.A(new d.a.o0.w.a(1, 2, null));
                        return;
                    }
                    MultiImgToolView multiImgToolView = this.f13011a;
                    multiImgToolView.q(multiImgToolView.l, true);
                    this.f13011a.j.setText(this.f13011a.u);
                    this.f13011a.o.invalidate();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view);
    }

    /* loaded from: classes3.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WriteImagesInfo f13012e;

        /* renamed from: f  reason: collision with root package name */
        public Context f13013f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.o0.b0.b f13014g;

        /* renamed from: h  reason: collision with root package name */
        public n f13015h;

        /* renamed from: i  reason: collision with root package name */
        public b f13016i;
        public boolean j;

        /* loaded from: classes3.dex */
        public class a implements d.a.o0.a0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f13017e;

            public a(c cVar, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13017e = viewGroup;
            }

            @Override // d.a.o0.a0.b
            public void a(d.a.c.k.d.a aVar, String str, boolean z) {
                TbImageView tbImageView;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f13017e.findViewWithTag(str)) == null || aVar == null) {
                    return;
                }
                tbImageView.invalidate();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f13018e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f13019f;

            public b(c cVar, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13019f = cVar;
                this.f13018e = viewGroup;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (indexOfChild = this.f13018e.indexOfChild(view)) < 0) {
                    return;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) this.f13019f.getItem(indexOfChild);
                if (!(imageFileInfo != null && new File(imageFileInfo.getFilePath()).exists())) {
                    l.I(this.f13019f.f13013f, R.string.editor_mutiiamge_image_error);
                } else if (this.f13019f.f13015h != null) {
                    this.f13019f.f13015h.d(new d.a.o0.w.a(15, 0, Integer.valueOf(indexOfChild)));
                }
            }
        }

        /* renamed from: com.baidu.tbadk.editortools.imagetool.MultiImgToolView$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0186c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ FrameLayout f13020e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f13021f;

            public View$OnClickListenerC0186c(c cVar, FrameLayout frameLayout) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, frameLayout};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13021f = cVar;
                this.f13020e = frameLayout;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13021f.f13016i == null) {
                    return;
                }
                this.f13021f.f13016i.a(this.f13020e);
            }
        }

        public c(Context context, d.a.o0.b0.b bVar, n nVar, b bVar2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bVar, nVar, bVar2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13012e = null;
            this.j = true;
            this.f13013f = context;
            this.f13014g = bVar;
            this.f13015h = nVar;
            this.f13016i = bVar2;
            this.j = z;
        }

        public void d(WriteImagesInfo writeImagesInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeImagesInfo) == null) {
                this.f13012e = writeImagesInfo;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                WriteImagesInfo writeImagesInfo = this.f13012e;
                if (writeImagesInfo == null) {
                    return 0;
                }
                return writeImagesInfo.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f13012e.getChosedFiles().get(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = (FrameLayout) LayoutInflater.from(this.f13013f).inflate(R.layout.editor_muti_image_item, (ViewGroup) null);
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f13012e.getChosedFiles(), i2);
                if (imageFileInfo == null) {
                    return null;
                }
                int measuredWidth = (viewGroup.getMeasuredWidth() - (this.f13013f.getResources().getDimensionPixelSize(R.dimen.ds66) * 2)) + this.f13013f.getResources().getDimensionPixelSize(R.dimen.ds32);
                FrameLayout frameLayout = (FrameLayout) view;
                LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.iv_container);
                FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(R.id.shadow_container);
                TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.iv);
                tbImageView.setGifIconSupport(true);
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(imageFileInfo.isLong());
                if (measuredWidth > 0) {
                    int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                    int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                    SkinManager.setBackgroundResource(frameLayout2, R.drawable.bg_add_photo);
                    frameLayout2.setForeground(SkinManager.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(d.a.o0.b0.g.d.g(paddingRight, measuredHeight));
                    tbImageView.setTag(imageFileInfo.toCachedKey(true));
                    if (this.f13014g.d(imageFileInfo, new a(this, viewGroup), true) != null) {
                        tbImageView.invalidate();
                    }
                }
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
                if (this.j) {
                    frameLayout.setOnClickListener(new b(this, viewGroup));
                }
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.delete);
                SkinManager.setImageResource(imageView, R.drawable.btn_add_photo_close);
                imageView.setOnClickListener(new View$OnClickListenerC0186c(this, frameLayout));
                frameLayout.setContentDescription(frameLayout.getResources().getString(R.string.editor_image) + (i2 + 1) + " " + imageFileInfo.getModifyTime());
                return frameLayout;
            }
            return (View) invokeILL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2025497908, "Lcom/baidu/tbadk/editortools/imagetool/MultiImgToolView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2025497908, "Lcom/baidu/tbadk/editortools/imagetool/MultiImgToolView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImgToolView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = null;
        this.r = 13;
        this.s = 10;
        this.t = false;
        this.v = new a(this);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.c
    public void a(int i2, int i3) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 == i3 || (writeImagesInfo = this.l) == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = this.l.getChosedFiles();
        chosedFiles.add(i3, chosedFiles.remove(i2));
    }

    @Override // d.a.o0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    @Override // d.a.o0.w.n
    public void d(d.a.o0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (editorTools = this.o) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13010i : (DragHorizonScrollView) invokeV.objValue;
    }

    public DragLayer getDragLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (DragLayer) invokeV.objValue;
    }

    public int getImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l.getChosedFiles().size() : invokeV.intValue;
    }

    public TextView getMutiImageTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    @Override // d.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : invokeV.intValue;
    }

    @Override // d.a.o0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
        }
    }

    @Override // d.a.o0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // d.a.o0.w.b
    public void onAction(d.a.o0.w.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f53487a;
        if (i2 == 9) {
            c cVar = this.n;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
            }
            d(new d.a.o0.w.a(2, this.s, null));
        } else if (i2 == 12 && (obj = aVar.f53489c) != null && (obj instanceof d.a.o0.w.r.a)) {
            q(((d.a.o0.w.r.a) obj).f53510a, ((d.a.o0.w.r.a) obj).f53511b);
        }
    }

    @Override // d.a.o0.w.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.common_color_10255);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f13010i = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
            this.j = (TextView) findViewById(R.id.muti_image_tips);
            this.k = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
        }
    }

    public final void q(WriteImagesInfo writeImagesInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, writeImagesInfo, z) == null) {
            this.l = writeImagesInfo;
            c cVar = new c(getContext(), this.m, this, this.v, this.s == 10);
            this.n = cVar;
            cVar.d(this.l);
            this.f13010i.setAdapter(this.n, z);
            int maxItemNum = this.f13010i.getMaxItemNum();
            int size = writeImagesInfo.size();
            if (size == 1 && !TextUtils.isEmpty(this.q)) {
                this.j.setText(this.q);
            } else if (!w && size > 1) {
                this.j.setText(R.string.editor_mutiiamge_drag_tip);
                w = true;
                TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
            } else {
                this.j.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            }
            if (size > 0) {
                String str = size + "";
            }
        }
    }

    public void setAsyncLocalImageLoader(d.a.o0.b0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setDefaultTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.q = str;
        }
    }

    public void setDeleteAction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.r = i2;
        }
    }

    @Override // d.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editorTools) == null) {
            this.o = editorTools;
        }
    }

    public void setNeedQuit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.t = z;
        }
    }

    public void setNoPicTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (StringUtils.isNULL(str)) {
                this.u = " ";
            } else {
                this.u = str;
            }
        }
    }

    public void setTargetToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.s = i2;
        }
    }

    @Override // d.a.o0.w.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.p = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = null;
        this.r = 13;
        this.s = 10;
        this.t = false;
        this.v = new a(this);
    }
}
