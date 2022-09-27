package com.baidu.tieba;

import android.app.Activity;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.floatball.FullScreenLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b07 implements Window.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final FullScreenLayout b;
    public long c;

    public b07(@NonNull Activity activity, @NonNull FullScreenLayout fullScreenLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, fullScreenLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = fullScreenLayout;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) ? this.a.dispatchGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
            if (4 == keyEvent.getKeyCode()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.c > 500 && this.b.N()) {
                    this.c = currentTimeMillis;
                    return false;
                }
            }
            return this.a.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keyEvent)) == null) ? this.a.dispatchKeyShortcutEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, accessibilityEvent)) == null) ? this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) ? this.a.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) ? this.a.dispatchTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, actionMode) == null) {
            this.a.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, actionMode) == null) {
            this.a.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, @NonNull Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, menu)) == null) ? this.a.onCreatePanelMenu(i, menu) : invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    @Nullable
    public View onCreatePanelView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? this.a.onCreatePanelView(i) : (View) invokeI.objValue;
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, @NonNull MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, menuItem)) == null) ? this.a.onMenuItemSelected(i, menuItem) : invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i, @NonNull Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, menu)) == null) ? this.a.onMenuOpened(i, menu) : invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i, @NonNull Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, menu) == null) {
            this.a.onPanelClosed(i, menu);
        }
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i, @Nullable View view2, @NonNull Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048592, this, i, view2, menu)) == null) ? this.a.onPreparePanel(i, view2, menu) : invokeILL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a.onSearchRequested() : invokeV.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, layoutParams) == null) {
            this.a.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.a.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, callback)) == null) ? this.a.onWindowStartingActionMode(callback) : (ActionMode) invokeL.objValue;
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, searchEvent)) == null) ? this.a.onSearchRequested(searchEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, callback, i)) == null) ? this.a.onWindowStartingActionMode(callback, i) : (ActionMode) invokeLI.objValue;
    }
}
