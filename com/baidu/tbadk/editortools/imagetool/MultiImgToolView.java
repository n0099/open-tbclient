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
import c.a.d.f.a.d;
import c.a.s0.x.n;
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
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class MultiImgToolView extends DragContainer implements n, DragHorizonScrollView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public DragHorizonScrollView f42415i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42416j;

    /* renamed from: k  reason: collision with root package name */
    public DragLayer f42417k;
    public WriteImagesInfo l;
    public c.a.s0.d0.b m;
    public c n;
    public EditorTools o;
    public int p;
    public String q;
    public int r;
    public int s;
    public boolean t;
    public String u;
    public b v;

    /* loaded from: classes11.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImgToolView a;

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
            this.a = multiImgToolView;
        }

        @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f42415i.isInDelete()) {
                return;
            }
            this.a.delete(view);
            int delete = this.a.f42415i.delete(view);
            if (delete < 0 || delete >= this.a.l.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.a.l.getChosedFiles().remove(delete);
            if (remove.isTempFile()) {
                d.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            int maxItemNum = this.a.f42415i.getMaxItemNum();
            int size = this.a.l.size();
            this.a.f42416j.setText(this.a.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            int size2 = this.a.l.getChosedFiles().size();
            if (this.a.o != null) {
                this.a.o.sendAction(new c.a.s0.x.a(this.a.r, -1, null));
                if (size2 > 0) {
                    this.a.o.sendAction(new c.a.s0.x.a(2, this.a.s, String.valueOf(size2)));
                } else {
                    this.a.o.sendAction(new c.a.s0.x.a(2, this.a.s, null));
                }
                if (maxItemNum == 1 && size2 == 0) {
                    if (this.a.t) {
                        this.a.o.sendAction(new c.a.s0.x.a(1, 2, null));
                        return;
                    }
                    MultiImgToolView multiImgToolView = this.a;
                    multiImgToolView.k(multiImgToolView.l, true);
                    this.a.f42416j.setText(this.a.u);
                    this.a.o.invalidate();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(View view);
    }

    /* loaded from: classes11.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WriteImagesInfo f42418e;

        /* renamed from: f  reason: collision with root package name */
        public Context f42419f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.s0.d0.b f42420g;

        /* renamed from: h  reason: collision with root package name */
        public n f42421h;

        /* renamed from: i  reason: collision with root package name */
        public b f42422i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f42423j;

        /* loaded from: classes11.dex */
        public class a implements c.a.s0.c0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f42424e;

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
                this.f42424e = viewGroup;
            }

            @Override // c.a.s0.c0.b
            public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
                TbImageView tbImageView;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f42424e.findViewWithTag(str)) == null || aVar == null) {
                    return;
                }
                tbImageView.invalidate();
            }
        }

        /* loaded from: classes11.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f42425e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f42426f;

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
                this.f42426f = cVar;
                this.f42425e = viewGroup;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (indexOfChild = this.f42425e.indexOfChild(view)) < 0) {
                    return;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) this.f42426f.getItem(indexOfChild);
                if (!(imageFileInfo != null && new File(imageFileInfo.getFilePath()).exists())) {
                    c.a.d.f.p.n.I(this.f42426f.f42419f, R.string.editor_mutiiamge_image_error);
                } else if (this.f42426f.f42421h != null) {
                    this.f42426f.f42421h.sendAction(new c.a.s0.x.a(15, 0, Integer.valueOf(indexOfChild)));
                }
            }
        }

        /* renamed from: com.baidu.tbadk.editortools.imagetool.MultiImgToolView$c$c  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class View$OnClickListenerC1880c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ FrameLayout f42427e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f42428f;

            public View$OnClickListenerC1880c(c cVar, FrameLayout frameLayout) {
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
                this.f42428f = cVar;
                this.f42427e = frameLayout;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42428f.f42422i == null) {
                    return;
                }
                this.f42428f.f42422i.a(this.f42427e);
            }
        }

        public c(Context context, c.a.s0.d0.b bVar, n nVar, b bVar2, boolean z) {
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
            this.f42418e = null;
            this.f42423j = true;
            this.f42419f = context;
            this.f42420g = bVar;
            this.f42421h = nVar;
            this.f42422i = bVar2;
            this.f42423j = z;
        }

        public void d(WriteImagesInfo writeImagesInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeImagesInfo) == null) {
                this.f42418e = writeImagesInfo;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                WriteImagesInfo writeImagesInfo = this.f42418e;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f42418e.getChosedFiles().get(i2) : invokeI.objValue;
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
                    view = (FrameLayout) LayoutInflater.from(this.f42419f).inflate(R.layout.editor_muti_image_item, (ViewGroup) null);
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f42418e.getChosedFiles(), i2);
                if (imageFileInfo == null) {
                    return null;
                }
                int measuredWidth = (viewGroup.getMeasuredWidth() - (this.f42419f.getResources().getDimensionPixelSize(R.dimen.ds66) * 2)) + this.f42419f.getResources().getDimensionPixelSize(R.dimen.ds32);
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
                    imageFileInfo.addPageAction(c.a.s0.d0.i.d.g(paddingRight, measuredHeight));
                    tbImageView.setTag(imageFileInfo.toCachedKey(true));
                    if (this.f42420g.d(imageFileInfo, new a(this, viewGroup), true) != null) {
                        tbImageView.invalidate();
                    }
                }
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
                if (this.f42423j) {
                    frameLayout.setOnClickListener(new b(this, viewGroup));
                }
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.delete);
                SkinManager.setImageResource(imageView, R.drawable.btn_add_photo_close);
                imageView.setOnClickListener(new View$OnClickListenerC1880c(this, frameLayout));
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

    @Override // c.a.s0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42415i : (DragHorizonScrollView) invokeV.objValue;
    }

    public DragLayer getDragLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42417k : (DragLayer) invokeV.objValue;
    }

    public int getImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l.getChosedFiles().size() : invokeV.intValue;
    }

    public TextView getMutiImageTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42416j : (TextView) invokeV.objValue;
    }

    @Override // c.a.s0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : invokeV.intValue;
    }

    @Override // c.a.s0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.s0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f42415i = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
            this.f42416j = (TextView) findViewById(R.id.muti_image_tips);
            this.f42417k = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
        }
    }

    public final void k(WriteImagesInfo writeImagesInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, writeImagesInfo, z) == null) {
            this.l = writeImagesInfo;
            c cVar = new c(getContext(), this.m, this, this.v, this.s == 10);
            this.n = cVar;
            cVar.d(this.l);
            this.f42415i.setAdapter(this.n, z);
            int maxItemNum = this.f42415i.getMaxItemNum();
            int size = writeImagesInfo.size();
            if (size == 1 && !TextUtils.isEmpty(this.q)) {
                this.f42416j.setText(this.q);
            } else if (!w && size > 1) {
                this.f42416j.setText(R.string.editor_mutiiamge_drag_tip);
                w = true;
                TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
            } else {
                this.f42416j.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            }
            if (size > 0) {
                String str = size + "";
            }
        }
    }

    @Override // c.a.s0.x.b
    public void onAction(c.a.s0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 9) {
            c cVar = this.n;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
            }
            sendAction(new c.a.s0.x.a(2, this.s, null));
        } else if (i2 == 12 && (obj = aVar.f14519c) != null && (obj instanceof c.a.s0.x.r.a)) {
            k(((c.a.s0.x.r.a) obj).a, ((c.a.s0.x.r.a) obj).f14545b);
        }
    }

    @Override // c.a.s0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.common_color_10255);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.c
    public void onSwapData(int i2, int i3) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) || i2 == i3 || (writeImagesInfo = this.l) == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = this.l.getChosedFiles();
        chosedFiles.add(i3, chosedFiles.remove(i2));
    }

    @Override // c.a.s0.x.n
    public void sendAction(c.a.s0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || (editorTools = this.o) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    public void setAsyncLocalImageLoader(c.a.s0.d0.b bVar) {
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

    @Override // c.a.s0.x.n
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

    @Override // c.a.s0.x.n
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
